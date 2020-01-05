package shop.service.impl;

import shop.entity.User;
import shop.enums.UserRole;
import shop.menu.admin.AdminMenu;
import shop.menu.user.UserMenu;
import shop.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UUID uuid = UUID.randomUUID();
    private User user = new User();

    @Override
    public boolean login(String email, String password) {
        // waiting for dao
        return email.equals(user.getEmail()) && password.equals(user.getPassword());
    }

    @Override
    public boolean register(String email, String password) {
        return false;
    }

    public boolean isAdmin() {
        // waiting for dao
        return user.getRole().equals(UserRole.ADMIN);
    }

    public void getMenu() {
       if (isAdmin()) new AdminMenu().show();
       else new UserMenu().show();
    }

    public User registerUser(String email, String password, String name, String phoneNumber) {
        user.setId(uuid.toString());
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setRole(UserRole.USER);
        return user;
    }

    public void putNewUser() {
        // waiting for dao
    }
}
