package shop.menu.admin;

import shop.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    //privet OrderService orderService = new OrderService();
    private boolean start;

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

        start = true;

        while (start) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    //orderService.confirmOrder(orderId);
                    break;
                case 2:
                    //orderService.deleteOrder(orderId);
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