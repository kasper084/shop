package shop.menu.user;

import shop.entity.User;
import shop.menu.Menu;
import shop.service.OrderService;
import shop.service.impl.OrderServiceImpl;
import shop.service.session.UserSession;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class OrderMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private OrderService orderService = new OrderServiceImpl();

    @Override
    public void addOptions() {
        options.add("1. Show order history");
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
                        if (!orderService.getAllOrdersForUser().isEmpty()) {
                            System.out.println("Your orders history:");
                            System.out.println(orderService.getAllOrdersForUser());
                        } else {
                            System.out.println("No orders yet");
                        }
                        System.out.println("Press \"0\" to go back");
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
            System.out.println("Please choose the number from the menu");
            new OrderMenu().show();
        }
    }

    @Override
    public void close() {
        new UserMenu().show();
    }
}