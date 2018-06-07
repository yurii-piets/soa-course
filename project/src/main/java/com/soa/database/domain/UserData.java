package com.soa.database.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "USER_DATA")
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
    @Column(length = 6, unique = true)
    private Integer index;

    @NotNull
    @Column(length = 50, unique = true)
    private String name;

    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Builder
    public UserData(Integer index, String name, String password, UserRole role) {
        this.index = index;
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
