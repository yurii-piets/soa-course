package com.soa.zad1.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private String login;

    private String password;

    private LocalDateTime loginDate;

    @Builder
    public User(String login, String password){
        this.login = login;
        this.password = password;
        this.loginDate = LocalDateTime.now();
    }
}
