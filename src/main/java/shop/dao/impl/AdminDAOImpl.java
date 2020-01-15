package shop.dao.impl;

import shop.dao.AdminDAO;

public class AdminDAOImpl implements AdminDAO {
    private static final String adminEmail = "admin@adm.in";
    private static final String adminPassword = "admin";

    @Override
    public boolean login(String email, String password) {
        return email.equals(adminEmail) && password.equals(adminPassword);
    }
}
