package shop.menu;

import shop.entity.User;
import shop.menu.admin.AdminMenu;
import shop.menu.user.UserMenu;
import shop.service.AdminService;
import shop.service.UserService;
import shop.service.session.UserSession;
import shop.service.impl.AdminServiceImpl;
import shop.service.impl.UserServiceImpl;

import java.util.*;

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

        try {
            while (true) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        Optional<User> loggedUser = userService.login(credentialsMenu.getEmail(),
                                credentialsMenu.getPassword());
                        UserSession.setInstance(loggedUser);
                        loggedUser.ifPresentOrElse
                                (result -> {
                                    new UserMenu().show();
                                }, () -> System.out.println("Try again or register"));
                        break;
                    case 2:
                        if (adminService.login(credentialsMenu.getEmail(),
                                credentialsMenu.getPassword())) {
                            new AdminMenu().show();
                        } else {
                            System.out.println("Invalid credentials. Try again");
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

        } catch (IllegalArgumentException i) {
            System.out.println(i.getMessage() + "\n");
            new LoginMenu().show();
        } catch (InputMismatchException i) {
            System.out.println("Please choose the number from the menu");
            new LoginMenu().show();
        }
    }

    @Override
    public void close() {
        System.exit(0);
    }
}