package shop.service.impl;

import shop.dao.UserDAO;
import shop.dao.impl.UserDAOImpl;
import shop.entity.User;
import shop.enums.UserRole;
import shop.service.UserService;
import shop.utils.PasswordEncoder;

import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private PasswordEncoder passwordEncoder = new PasswordEncoder();
    private UserDAO userDAO = new UserDAOImpl();

    @Override
    public boolean login(String email, String password) {
        Optional<User> optUser = userDAO.findUser(email);
        return optUser.map(user -> user.getPassword()
                .equals(passwordEncoder.decode(password)))
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
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setRole(UserRole.USER);
        if (!isExist(email)) save(user);
    }

    private void save(User user) {
        userDAO.saveUser(user);
    }
}