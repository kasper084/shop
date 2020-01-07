package shop.service;

public interface UserService {

    boolean login(String username, String password);

    boolean registered(String username, String password);
}
