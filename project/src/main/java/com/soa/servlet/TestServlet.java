package com.soa.servlet;

import com.soa.database.domain.UserData;
import com.soa.database.service.DataAccessService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.soa.database.domain.UserData.UserRole.ADMIN;
import static com.soa.util.CryptoUtil.crypt;


@WebServlet("/foo")
public class TestServlet extends HttpServlet {

    @EJB
    private DataAccessService dataAccessService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dataAccessService.save(UserData.builder()
                .index(112789)
                .name("Admin1")
                .password(crypt("admin"))
                .role(ADMIN)
                .build());
        super.doGet(req, resp);
    }
}
