package shop.service;

import shop.entity.User;

import java.util.Optional;

public interface UserService {

    boolean login(String username, String password);

    boolean isExist(String username);

    void registerUser(String email, String password, String name, String phone);

    void updateUser(User user);

    void deleteUser(User user);

    Optional<User> findUser(String email);
}