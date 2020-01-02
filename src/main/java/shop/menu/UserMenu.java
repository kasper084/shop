package shop.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    //privet UserService userService = newUserService();

    public void addToOptions() {
        options.add("1. Product list");
        options.add("2. My orders");
        options.add("0. Exit");
    }

    @Override
    public void show() {
        addToOptions();
        showOptions(options);

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:

            }
        }
    }

    @Override
    public void close() {
        System.exit(0);
    }
}