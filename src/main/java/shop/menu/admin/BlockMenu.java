package shop.menu.admin;

import shop.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlockMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    //privet UserService userService = newUserService();
    private boolean start;


    @Override
    public void addOptions() {
        options.add("1. Block user");
        options.add("2. Unblock user");
        options.add("0. Go back");
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
                    //userService.blockUser(userId);
                    break;
                case 2:
                    //userService.unblockUser(userId)
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
        start = false;
        new AdminMenu().show();
    }
}