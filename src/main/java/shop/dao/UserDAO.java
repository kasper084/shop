package shop.dao;

import shop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    void saveUser(User user);

    void deleteUser(User user);

    void updateUser(User user);

    boolean isExist(String email);

    List<User> findAll();

    default Optional<User> findUser(String email) {
        return Optional.empty();
    }
}