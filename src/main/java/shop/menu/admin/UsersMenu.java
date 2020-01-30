package shop.menu.admin;

import shop.menu.CredentialsMenu;
import shop.menu.Menu;
import shop.service.AdminService;
import shop.service.impl.AdminServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static shop.ExceptionMessages.PLEASE_CHOOSE_NUMBER_FROM_MENU;

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
                        if (!adminService.getActiveUsers().isEmpty()) {
                            System.out.printf("Active Users: \n%s%n",
                                    adminService.getActiveUsers());
                            adminService.blockUser(credentialsMenu.getEmail());
                            System.out.println("User was blocked");
                            showOptions(options);
                        } else {
                            System.out.println("There are no active users yet");
                            new UsersMenu().show();
                        }
                        break;
                    case 2:
                        if (!adminService.getInactiveUsers().isEmpty()) {
                            System.out.printf("Blocked Users: \n%s%n",
                                    adminService.getInactiveUsers());
                            adminService.unblockUser(credentialsMenu.getEmail());
                            System.out.println("User was unblocked");
                            showOptions(options);
                        } else {
                            System.out.println("There are no blocked users yet");
                            new UsersMenu().show();
                        }
                        break;
                    case 3:
                        if (!adminService.getAllEmails().isEmpty()) {
                            System.out.printf("All users: \n%s%n",
                                    adminService.getAllEmails());
                            adminService.deleteUser(credentialsMenu.getEmail());
                            System.out.println("User was deleted");
                            showOptions(options);
                        } else {
                            System.out.println("There are no users yet");
                            new UsersMenu().show();
                        }
                        break;
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
                System.out.println(PLEASE_CHOOSE_NUMBER_FROM_MENU);
                new UsersMenu().show();
            }
        }
    }

    @Override
    public void close() {
        new AdminMenu().show();
    }
}