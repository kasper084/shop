package shop.dao.impl;

import shop.dao.UserDAO;
import shop.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository implements UserDAO {
    private Map<String, User> userMap = new HashMap<>();

    @Override
    public void saveUser(User user) {
        userMap.put(user.getId(), user);
    }

    @Override
    public void updateUser() {
    }

    @Override
    public void deleteUser() {

    }

    @Override
    public Optional<User> getUser(String email, String password) {
        return userMap.values().stream()
                 .filter(user -> user.getEmail().equals(email)
                 && user.getPassword().equals(password))
                .findFirst();
    }
}
