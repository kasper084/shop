package shop.service.impl;

import shop.dao.impl.UserRepository;
import shop.entity.User;
import shop.enums.UserRole;
import shop.menu.admin.AdminMenu;
import shop.menu.user.UserMenu;
import shop.service.UserService;

import java.util.Scanner;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository = new UserRepository();
    private Scanner scanner = new Scanner(System.in);
    private UUID uuid = UUID.randomUUID();
    private User user = new User();

    @Override
    public boolean login(String email, String password) {
        return userRepository.getUser(email, password).isEmpty();
    }

    @Override
    public boolean registered (String email, String password) {
        return userRepository.getUser(email, password).isEmpty();
    }


    private boolean isAdmin() {
        //need better solution
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
        if (!registered(email, password)) putNewUser();
    }

    private void putNewUser() {
        userRepository.saveUser(user);
    }

    public String getEmail() {
        System.out.println("Enter email");
        String email = scanner.nextLine();
        if (!isEmailValid(email)){
            System.out.println("Invalid");
            getEmail();
        } return email;
    }

    public String getPassword() {
        System.out.println("Enter password");
        String password = scanner.nextLine();
        return password;
    }

    public String getName() {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        return name;
    }

    public String getPhone() {
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        return phoneNumber;
    }


    public boolean isEmailValid(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

}
