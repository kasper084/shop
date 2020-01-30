package shop.menu.user;

import shop.entity.Order;
import shop.entity.User;
import shop.menu.Menu;
import shop.service.OrderService;
import shop.service.impl.OrderServiceImpl;
import shop.service.session.UserSession;

import java.util.*;

import static shop.ExceptionMessages.PLEASE_CHOOSE_NUMBER_FROM_MENU;

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
                        User user = UserSession.getInstance().getUser();
                        List<Order> orders = null;
                        if (Objects.nonNull(user)) {
                            orders = orderService.getAllOrdersForCurrentUser(user.getId());
                        } else System.out.println("No logged user");

                        if (!orders.isEmpty()) {
                            for (Order order : orders) {
                                System.out.printf("[%s]%n", order);
                            }
                        } else System.out.println("No orders found");

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
            System.out.println(PLEASE_CHOOSE_NUMBER_FROM_MENU);
            new OrderMenu().show();
        }
    }

    @Override
    public void close() {
        new UserMenu().show();
    }
}