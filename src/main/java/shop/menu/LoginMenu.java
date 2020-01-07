package shop.menu;

import shop.menu.user.UserMenu;
import shop.service.impl.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMenu implements Menu {
    private UserServiceImpl userService = new UserServiceImpl();
    private List<String> options = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addOptions() {
        options.add("1. Login");
        options.add("2. Register user");
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
                    if (!userService.login(userService.getEmail(),
                            userService.getPassword())) {
                        userService.getMenu();
                    } else {
                        System.out.println("Try again or register");
                        showOptions(options);
                    }
                    break;
                case 2:
                    userService.registerUser(userService.getEmail(),
                            userService.getPassword(),
                            userService.getName(),
                            userService.getPhone());
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