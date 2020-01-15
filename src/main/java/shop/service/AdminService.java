package shop.service;

import java.util.List;

public interface AdminService {

    boolean login(String email, String password);

    boolean blockUser(String userId);

    boolean unblockUser(String userId);

    boolean deleteUser(String userEmail);

    List<String> getActiveUsers();

    List<String> getInactiveUsers();

    List<String> getAllUsers();
}