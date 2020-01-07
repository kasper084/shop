package shop.service.impl;

import shop.dao.impl.UserRepository;
import shop.entity.User;
import shop.enums.UserRole;
import shop.menu.admin.AdminMenu;
import shop.menu.user.UserMenu;
import shop.service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepository();
    private UUID uuid = UUID.randomUUID();
    private User user = new User();

    @Override
    public boolean login(String email, String password) {
        if (userRepository.getUser(email, password).isEmpty()) return false;
        return true;
    }

    @Override
    public boolean register(String email, String password) {
        return false;
    }

    public boolean isAdmin() {

        return false;
    }

    public void getMenu() {
        if (isAdmin()) new AdminMenu().show();
        else new UserMenu().show();
    }

    public void registerUser(String email, String password, String name, String phoneNumber) {
        user.setId(uuid.toString());
        user.setEmail(email);
        user.setPassword(password);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setRole(UserRole.USER);
        putNewUser();
    }

    private void putNewUser() {
        userRepository.saveUser(user);
    }
}
