package shop.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private String login;
    private String password;
    //privet UserService userService = newUserService();

    public void addOptions() {
        options.add("1. Login");
        options.add("2. Register user");
        options.add("0. Exit");
    }

    public void getLoginAndPassword() {
        System.out.println("Enter login");
        login = scanner.nextLine();
        System.out.println("Enter password");
        password = scanner.nextLine();
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    getLoginAndPassword();
                    //if(admin) new AdminMenu.show();
                    //if(user) new UserMenu.show();
                    break;
                case 2:
                    getLoginAndPassword();
                    // userService.registerUser(login, password);
                case 0:
                    close();
                    break;
            }
        }

    }

    @Override
    public void close() {
        System.exit(0);
    }
}
