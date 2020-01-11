package shop.utils;

import java.util.Base64;

public class PasswordEncoder {

    public String encode(String password) {
        return Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String decode(String password) {
        byte[] encodedPassword = Base64.getDecoder()
                .decode(password);
        return new String(encodedPassword);
    }
}