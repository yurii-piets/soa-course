package com.soa.database.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class UserData {

    public enum UserRole {
        ADMIN,
        USER
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 6)
    private Integer index;

    @Column(length = 50)
    private String name;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
