package shop.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private boolean start;
    //privet UserService userService = newUserService();

    public void addOptions() {
        options.add("1. Login");
        options.add("2. Register user");
        options.add("0. Exit");
    }

    public void getLoginAndPassword() {
        System.out.println("Enter email");
        email = scanner.nextLine();
        System.out.println("Enter password");
        password = scanner.nextLine();
    }

    public void getUserInfo() {
        getLoginAndPassword();
        System.out.println("Enter name");
        name = scanner.nextLine();
        System.out.println("Enter phone number");
        phoneNumber = scanner.nextLine();
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);

        start = true;

        while (start) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    getLoginAndPassword();
                    //if(admin) new AdminMenu.show();
                    //if(user) new UserMenu.show();
                    break;
                case 2:
                    getUserInfo();
                    //userService.createUser();
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
        start = false;
        System.exit(0);
    }
}