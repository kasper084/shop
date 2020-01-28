package shop.service;

import shop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Boolean login(String username, String password);

    boolean isExist(String username);

    void registerUser(String email, String password, String name, String phone);

    void updateUser(User user);

    void deleteUser(User user);

    List<User> getAll();

    Optional<User> findUser(String email);
}