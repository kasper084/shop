package shop.dao;

import shop.entity.User;

public interface UserDAO {
    void saveUser(User user);

    void updateUser();

    void deleteUser();

    void getUser();
}
