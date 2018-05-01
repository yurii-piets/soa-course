package com.soa.zad1.bean;

import com.soa.zad1.domain.User;
import lombok.Getter;

import javax.ejb.Singleton;
import java.util.LinkedHashSet;
import java.util.Set;

@Singleton
public class UserBean {

    public static final String LOGIN_ATTRIBUTE_NAME = "login";
    public static final String PASSWORD_ATTRIBUTE_NAME = "password";

    @Getter
    private final Set<User> activeUsers = new LinkedHashSet<>();

    public void addUser(User user) {
        activeUsers.add(user);
    }

    public void removeUserByLogin(String login) {
        User user = activeUsers.stream()
                .filter(u -> u.getLogin().equals(login))
                .findFirst()
                .orElse(null);
        activeUsers.remove(user);
    }
}