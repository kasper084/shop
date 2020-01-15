package shop.menu;

import shop.menu.admin.AdminMenu;
import shop.menu.user.UserMenu;
import shop.service.AdminService;
import shop.service.UserService;
import shop.service.impl.AdminServiceImpl;
import shop.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMenu implements Menu {
    private CredentialsMenu credentialsMenu = new CredentialsMenu();
    private AdminService adminService = new AdminServiceImpl();
    private UserService userService = new UserServiceImpl();
    private List<String> options = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addOptions() {
        options.add("1. Login");
        options.add("2. Login as Admin");
        options.add("3. Register user");
        options.add("0. Exit");
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (userService.login(credentialsMenu.getEmail(),
                            credentialsMenu.getPassword())) {
                        new UserMenu().show();
                    } else {
                        System.out.println("Try again or register");
                        showOptions(options);
                    }
                    break;
                case 2:
                    if (adminService.login(credentialsMenu.getEmail(),
                            credentialsMenu.getPassword())) {
                        new AdminMenu().show();
                    } else {
                        System.out.println("No such admin");
                        showOptions(options);
                    }
                    break;
                case 3:
                    userService.registerUser(credentialsMenu.getEmail(),
                            credentialsMenu.getPassword(),
                            credentialsMenu.getName(),
                            credentialsMenu.getPhone());
                    new UserMenu().show();
                case 0:
                    close();
                    break;
                default:
                    showOptions(options);
                    break;
            }
        }
    }

    @Override
    public void close() {
        System.exit(0);
    }
}