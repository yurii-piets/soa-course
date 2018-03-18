package com.soa.servlet;

import javax.ejb.Stateful;
import java.util.HashMap;
import java.util.Map;

@Stateful
public class AuthService {

    private Map<String, String> users = new HashMap<String, String>() {{
        put("test", "test");
        put("test@test", "test");
    }};

    public boolean checkLogin(String email) {
        return users.containsKey(email);
    }

    public boolean checkCredentials(String email, String password) {
        return users.containsKey(email) && users.get(email).equals(password);
    }
}
