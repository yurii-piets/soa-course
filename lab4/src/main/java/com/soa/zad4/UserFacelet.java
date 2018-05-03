package com.soa.zad4;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SessionScoped
@ManagedBean(name = "userFacelet")
public class UserFacelet {

    private static final String EMAIL_PATTERN = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    private String name;

    @Pattern(regexp = EMAIL_PATTERN)
    private String email;

    @Min(10)
    @Max(100)
    private Integer age;

    @Pattern(regexp = "[mf]")
    private String sex;

    private String education;

    private Integer height;

    private String brest;

    private String miseczka;

    private String biodra;

    private String talia;

    private String nogi;

    private String klatka;

    private String pas;

    private String q1;
    private String q2;
    private String q3;
    private List<String> q4;
    private String q5;
    private String q6;
    private String q7;
    private String q8;
    private List<String> q4ans_female = new LinkedList<String>() {{
        add("bluza");
    }};
    private List<String> q4ans_male = new LinkedList<String>(){{
        add("niebluza");
    }};
}
