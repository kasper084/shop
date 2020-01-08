package shop.dao;

import shop.entity.User;

import java.util.Optional;

public interface UserDAO {
    void saveUser(User user);

    void updateUser();

    void deleteUser();

    boolean isExist(String email);

    default Optional<User> findUser(String email) {
        return Optional.empty();
    }
}
