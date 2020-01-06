package shop.dao.impl;

import shop.dao.UserDAO;
import shop.entity.User;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

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
    public void getUser() {
    }

}
