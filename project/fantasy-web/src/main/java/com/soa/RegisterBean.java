package com.soa;

import com.soa.domain.UserData;
import com.soa.service.DataAccessService;
import com.soa.util.CryptoUtil;
import lombok.Data;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Data
@ManagedBean
@SessionScoped
public class RegisterBean {

    @EJB
    private DataAccessService dataService;

    private Integer index;

    private String name;

    private String password;

    public void submit() {
        dataService.save(UserData.builder()
                .index(index)
                .login(name)
                .password(CryptoUtil.crypt(password))
                .role(UserData.UserRole.USER)
                .build());
    }
}
