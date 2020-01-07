package shop.dao;

import shop.entity.User;

import java.util.Optional;

public interface UserDAO {
    void saveUser(User user);

    void updateUser();

    void deleteUser();

    default Optional<User> getUser(String email, String password) {
        return Optional.empty();
    }
}
