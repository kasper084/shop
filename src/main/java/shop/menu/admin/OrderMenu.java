package shop.menu.admin;

import shop.menu.Menu;
import shop.menu.input.OrderInput;
import shop.service.AdminService;
import shop.service.impl.AdminServiceImpl;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static shop.ExceptionMessages.PLEASE_CHOOSE_NUMBER_FROM_MENU;

public class OrderMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private OrderInput orderInput = new OrderInput();
    private AdminService adminService = new AdminServiceImpl();

    @Override
    public void addOptions() {
        options.add("1. Confirm order");
        options.add("2. Delete order");
        options.add("0. Go back");
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
                        if (!adminService.getAllPendingOrders().isEmpty()) {
                            System.out.println(adminService.getAllPendingOrders());
                            adminService.confirmOrder(orderInput.getOrderId());
                            System.out.println("Order confirmed");
                            showOptions(options);
                        } else {
                            System.out.println("No orders yet");
                            new OrderMenu().show();
                        }
                        break;
                    case 2:
                        if (!adminService.getAllPendingOrders().isEmpty()) {
                            System.out.println(adminService.getAllPendingOrders());
                            adminService.declineOrder(orderInput.getOrderId());
                            System.out.println("Order canceled");
                            showOptions(options);
                        } else {
                            System.out.println("No orders yet");
                            new OrderMenu().show();
                        }
                        break;
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
            new OrderMenu().show();
        } catch (InputMismatchException i) {
            System.out.println(PLEASE_CHOOSE_NUMBER_FROM_MENU);
            new OrderMenu().show();
        }
    }

    @Override
    public void close() {
        new AdminMenu().show();
    }
}