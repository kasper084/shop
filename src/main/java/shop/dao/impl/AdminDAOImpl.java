package shop.dao.impl;

import shop.dao.AdminDAO;
import shop.entity.Admin;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class AdminDAOImpl implements AdminDAO {
    private Map<String, Admin> adminMap = new HashMap<>();

    @Override
    public boolean isExist(String email) {
        return findAdmin(email).isPresent();
    }

    @Override
    public Optional<Admin> findAdmin(String email) {
        return adminMap.values().stream()
                .filter(admin -> admin.getEmail().equals(email))
                .findFirst();
    }
}
