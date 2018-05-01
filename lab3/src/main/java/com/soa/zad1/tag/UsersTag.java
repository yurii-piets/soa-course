package com.soa.zad1.tag;

import com.soa.zad1.bean.UserBean;
import com.soa.zad1.domain.User;
import lombok.Getter;
import lombok.Setter;

import javax.inject.Inject;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class UsersTag extends SimpleTagSupport {

    @Inject
    private UserBean userBean;

    @Getter
    @Setter
    private String sort;

    @Getter
    @Setter
    private String color;

    @Override
    public void doTag() throws IOException {
        List<User> sortedUsers;
        if (sort.equals("down")) {
            sortedUsers = userBean.getActiveUsers().stream()
                    .sorted((u1, u2) -> u2.getLogin().compareTo(u1.getLogin()))
                    .collect(Collectors.toList());
        } else {
            sortedUsers = userBean.getActiveUsers().stream()
                    .sorted(Comparator.comparing(User::getLogin))
                    .collect(Collectors.toList());
        }

        JspWriter out = getJspContext().getOut();
        out.write("<table>");
        out.write(sortedUsers.stream()
                .map(u -> "<tr> <td>" + u.getLogin() + "</td> <td>" + u.getLoginDate() + "</td> </tr>")
                .collect(Collectors.joining()));
        out.write("</table>");
    }
}
