package com.soa;

import lombok.Data;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Data
@ManagedBean
@SessionScoped
public class UserBean {

    private String name;

    private String password;

}
