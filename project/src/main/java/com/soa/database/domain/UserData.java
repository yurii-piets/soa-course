package com.soa.database.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
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

    @NotNull
    @Column(length = 6)
    private Integer index;

    @NotNull
    @Column(length = 50)
    private String name;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
