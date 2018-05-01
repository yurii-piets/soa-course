package com.soa.zad1.tag;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

@Getter
@Setter
public class ParagrafTag extends SimpleTagSupport {

    private String head;

    private String alignment;

    private String color;

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write("<h1>" + head + "</h1>");
        out.print("<div align=\"" + alignment + "\">");
        out.print("<font color=\"" + color + "\">");
        getJspBody().invoke(out);
        out.print("</font>");
        out.print("</div>");
    }
}
