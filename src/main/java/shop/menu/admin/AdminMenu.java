package shop.menu.admin;

import shop.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    @Override
    public void addOptions() {
        options.add("1. Block/Unblock/Delete user");
        options.add("3. Order menu");
        options.add("4. Products menu");
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
                    new BlockMenu().show();
                    break;
                case 2:
                    new OrderMenu().show();
                    break;
                case 3:
                    new ProductMenu().show();
                    break;
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