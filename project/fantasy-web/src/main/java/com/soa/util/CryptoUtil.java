package com.soa.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class CryptoUtil {

    public static String crypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = password.getBytes();
            byte[] hash = md.digest(passwordBytes);
            return new String(Base64.getEncoder().encode(hash));
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
}
