package shop.dao;

import shop.entity.Admin;

import java.util.Optional;

public interface AdminDAO {
    boolean isExist(String email);

    default Optional<Admin> findAdmin(String email) {
        return Optional.empty();
    }
}