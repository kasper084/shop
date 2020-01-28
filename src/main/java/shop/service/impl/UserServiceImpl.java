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

    @Override
    public boolean login(String email, String password) {
        Optional<User> optUser = userDAO.findUser(email);
        return optUser.map(user -> user.getPassword()
                .equals(PasswordEncoder.encode(password)))
                .orElse(false);
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
    public Optional<User> findUser(String email) {
        return userDAO.findUser(email);
    }

    private void save(User user) {
        userDAO.saveUser(user);
    }
}