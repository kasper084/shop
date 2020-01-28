package shop.menu.admin;

import shop.menu.CredentialsMenu;
import shop.menu.Menu;
import shop.service.AdminService;
import shop.service.impl.AdminServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UsersMenu implements Menu {
    private CredentialsMenu credentialsMenu = new CredentialsMenu();
    private AdminService adminService = new AdminServiceImpl();
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    @Override
    public void addOptions() {
        options.add("1. Block user");
        options.add("2. Unblock user");
        options.add("3. Delete user");
        options.add("0. Go back");
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);

        while (true) {
            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        if (adminService.getActiveUsers().isEmpty()) {
                            System.out.println("There are no active users yet");
                            new UsersMenu();
                        }
                        System.out.printf("Active Users: \n%s%n",
                                adminService.getActiveUsers());
                        adminService.blockUser(credentialsMenu.getEmail());
                        System.out.println("User was blocked");
                        break;
                    case 2:
                        if (adminService.getActiveUsers().isEmpty()) {
                            System.out.println("There are no blocked users yet");
                            new UsersMenu();
                        }
                        System.out.printf("Blocked Users: \n%s%n",
                                adminService.getInactiveUsers());
                        adminService.unblockUser(credentialsMenu.getEmail());
                        System.out.println("User was unblocked");
                        break;
                    case 3:
                        if (adminService.getActiveUsers().isEmpty()) {
                            System.out.println("There are no users yet");
                            new UsersMenu();
                        }
                        System.out.printf("All suers: \n%s%n",
                                adminService.getAllUsers());
                        adminService.deleteUser(credentialsMenu.getEmail());
                        System.out.println("User was deleted");
                    case 0:
                        close();
                        break;
                    default:
                        showOptions(options);
                        break;
                }
            } catch (IllegalArgumentException i) {
                System.out.println(i.getMessage() + "\n");
                new UsersMenu().show();
            } catch (InputMismatchException i) {
                System.out.println("Please choose the number from the menu");
                new UsersMenu().show();
            }
        }
    }

    @Override
    public void close() {
        new AdminMenu().show();
    }
}