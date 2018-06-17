package com.soa.session;

import javax.ejb.Singleton;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class SessionManagerBean {

    private Map<String, HttpSession> usersOnline = new HashMap<>();

    public boolean isLocked(String name, HttpSession session) {
        if (usersOnline.containsKey(name)) {
            HttpSession httpSession = usersOnline.get(name);
            return !httpSession.getId().equals(session.getId());
        }
        usersOnline.put(name, session);
        return false;
    }

    public void logout(String name) {
        usersOnline.remove(name);
    }
}
