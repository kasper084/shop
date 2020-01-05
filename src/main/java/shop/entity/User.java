package shop.entity;

import shop.enums.UserRole;

public class User {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private UserRole role;

    public String getName() {
        return name;
    }

    public void setName(String a) {
        name = a;
    }

    public String getId() {
        return id;
    }

    public void setId(String a) {
        id = a;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String a) {
        email = a;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String a) {
        password = a;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String a) {
        phoneNumber = a;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}

