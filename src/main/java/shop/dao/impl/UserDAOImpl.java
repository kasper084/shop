package shop.dao.impl;

import shop.dao.UserDAO;
import shop.entity.User;
import shop.enums.UserRole;
import shop.enums.UserStatus;

import java.util.*;

public class UserDAOImpl implements UserDAO {
    private static Map<String, User> userMap = dataBuilder();

    private static Map<String, User> dataBuilder() {
        Map<String, User> userMap = new HashMap<>();
        User john = setUser("3","John", "john@mail.com", "cGFzMg==", "6666666");
        User dave = setUser("4","Dave", "dave@mail.com", "cGFzMQ==", "5555555");
        User vlad = setUser("5","Vlad", "vlad@mail.com", "cGFzMw==", "7777777");
        userMap.put(john.getId(), john);
        userMap.put(dave.getId(), dave);
        userMap.put(vlad.getId(), vlad);
        return userMap;
    }

    private static User setUser(String id, String name, String email, String password, String phoneNumber) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password); // must be encoded already
        user.setPhoneNumber(phoneNumber);
        user.setStatus(UserStatus.ACTIVE);
        user.setRole(UserRole.USER);
        return user;
    }

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
    public List<User> findAll() {
        return new ArrayList<>(userMap.values());
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