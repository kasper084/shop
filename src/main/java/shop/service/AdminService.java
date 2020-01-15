package shop.service;

public interface AdminService {

    boolean login(String email, String password);

    void blockUser(String userId);

    void unblockUser(String userId);

    void deleteUser(String userEmail);
}
