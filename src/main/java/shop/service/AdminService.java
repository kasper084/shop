package shop.service;

import shop.entity.Admin;

import java.util.Optional;

public interface AdminService {

    boolean login(String email, String password);

    boolean isExist(String email);

    void blockUser(String userId);

    void unblockUser(String userId);

    void deleteUser(String userEmail);

    Optional<Admin> findAdmin(String email);
}
