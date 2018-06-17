package com.soa.session;

import javax.ejb.Singleton;
import java.util.HashSet;
import java.util.Set;

@Singleton
public class SessionManagerBean {

    private Set<String> usersOnline = new HashSet<>();

    public boolean isOnline(String name) {
        boolean isOnline = usersOnline.contains(name);
        if (!isOnline) {
            usersOnline.add(name);
        }
        return isOnline;
    }

    public void logout(String name) {
        usersOnline.remove(name);
    }
}
