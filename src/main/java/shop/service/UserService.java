package shop.service;

public interface UserService {

    boolean login(String username, String password);

    boolean isExist(String username);

    void registerUser(String email, String password, String name, String phone);
}