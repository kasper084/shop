package shop.menu.user;

import shop.menu.LoginMenu;
import shop.menu.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static shop.ExceptionMessages.PLEASE_CHOOSE_NUMBER_FROM_MENU;

public class UserMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    @Override
    public void addOptions() {
        options.add("1. Product list");
        options.add("2. My orders");
        options.add("3. Logout");
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
                        new ProductMenu().show();
                        break;
                    case 2:
                        new OrderMenu().show();
                        break;
                    case 3:
                        new LoginMenu().show();
                    case 0:
                        close();
                        break;
                    default:
                        showOptions(options);
                        break;
                }
            }
        } catch (InputMismatchException i) {
            System.out.println(PLEASE_CHOOSE_NUMBER_FROM_MENU);
            new UserMenu().show();
        }
    }

    @Override
    public void close() {
        System.exit(0);
    }
}