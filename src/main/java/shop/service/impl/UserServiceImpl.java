package shop.service.impl;

import shop.dao.UserDAO;
import shop.dao.impl.UserDAOImpl;
import shop.entity.User;
import shop.enums.UserRole;
import shop.menu.admin.AdminMenu;
import shop.menu.user.UserMenu;
import shop.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
    private User user = new User();

    @Override
    public boolean login(String email, String password) {
        return userDAO.getUser(email).isPresent();
    }

    @Override
    public boolean isExist(String email) {
        return userDAO.isExist(email);
    }

    private boolean isAdmin(User user) {
        return user.getRole().equals(UserRole.ADMIN);
    }

    public void getMenu() {
        if (isAdmin(user)) new AdminMenu().show();
        else new UserMenu().show();
    }

    public void registerUser(String email, String password, String name, String phoneNumber) {
        user.setId(UUID.randomUUID().toString());
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setRole(UserRole.USER);
        if (!isExist(email)) save(user);
    }

    private void save(User user) {
        userDAO.saveUser(user);
    }
}