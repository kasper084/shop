package shop.service.impl;

import shop.dao.UserDAO;
import shop.dao.impl.UserDAOImpl;
import shop.entity.User;
import shop.enums.UserRole;
import shop.enums.UserStatus;
import shop.service.UserService;
import shop.utils.PasswordEncoder;

import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO = new UserDAOImpl();
    private static Optional<User> user;

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> optUser = userDAO.findUser(email);
         optUser.map(user -> user.getPassword()
                .equals(PasswordEncoder.decode(password)))
                .orElse(false);
        return optUser;
    }

    @Override
    public boolean isExist(String email) {
        return userDAO.isExist(email);
    }

    public void registerUser(String email, String password, String name, String phoneNumber) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(email);
        user.setPassword(PasswordEncoder.encode(password));
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setRole(UserRole.USER);
        user.setStatus(UserStatus.ACTIVE);
        if (!isExist(email)) save(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.deleteUser(user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.findAll();
    }

    @Override
    public List<String> getActiveUsers() {
        return getAll().stream()
                .filter(user -> user.getStatus().equals(UserStatus.ACTIVE))
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getInactiveUsers() {
        return getAll().stream()
                .filter(user -> user.getStatus().equals(UserStatus.BLOCKED))
                .map(User::getEmail)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findUser(String email) {
        return userDAO.findUser(email);
    }

    public static Optional<User> getLoggedUser() {
        return UserServiceImpl.user;
    }

    public static void setLogedUser(Optional<User> user) {
        UserServiceImpl.user = user;
    }

    private void save(User user) {
        userDAO.saveUser(user);
    }
}