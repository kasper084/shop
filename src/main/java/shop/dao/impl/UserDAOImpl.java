package shop.dao.impl;

import shop.dao.UserDAO;
import shop.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDAOImpl implements UserDAO {
    private Map<String, User> userMap = new HashMap<>();

    @Override
    public void saveUser(User user) {
        userMap.put(user.getId(), user);
    }


    @Override
    public void deleteUser(User user) {
        userMap.remove(user.getId(), user);
    }

    @Override
    public boolean isExist(String email) {
        return findUser(email).isPresent();
    }

    @Override
    public void updateUser(User user) {
        saveUser(user);
    }

    @Override
    public Optional<User> findUser(String email) {
        return userMap.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }
}