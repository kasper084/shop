package shop.utils;

import java.util.Base64;

public class PasswordEncoder {

    public static String encode(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public static String decode(String password) {
        byte[] encodedPassword = Base64.getDecoder()
                .decode(password);
        return new String(encodedPassword);
    }
}