package com.soa;

public class AuthContext {

    private static String username;
    private static String password;

    public static void setUsername(String username) {
        AuthContext.username = username;
    }

    public static void setPassword(String password) {
        AuthContext.password = password;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}
