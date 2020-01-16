package shop.service;

import java.util.List;

public interface AdminService {

    boolean login(String email, String password);

    void blockUser(String userId);

    void unblockUser(String userId);

    void deleteUser(String userEmail);

    List<String> getActiveUsers();

    List<String> getInactiveUsers();

    List<String> getAllUsers();
}