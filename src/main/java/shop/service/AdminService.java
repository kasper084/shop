package shop.service;

public interface AdminService {

    void blockUser(String userId);

    void unblockUser(String userId);
}
