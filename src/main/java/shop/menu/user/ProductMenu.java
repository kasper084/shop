package shop.menu.user;

import shop.entity.Order;
import shop.entity.Product;
import shop.entity.User;
import shop.menu.Menu;
import shop.menu.input.ProductInput;
import shop.service.OrderService;
import shop.service.ProductService;
import shop.service.session.UserSession;
import shop.service.impl.OrderServiceImpl;
import shop.service.impl.ProductServiceImpl;

import java.util.*;

import static shop.ExceptionMessages.PLEASE_CHOOSE_NUMBER_FROM_MENU;

public class ProductMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private ProductInput productInput = new ProductInput();
    private OrderService orderService = new OrderServiceImpl();
    private ProductService productService = new ProductServiceImpl();

    @Override
    public void addOptions() {
        options.add("1. Show products");
        options.add("2. Search for specific product");
        options.add("3. Add specific product to order");
        options.add("4. Order checkout");
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
                        for (Product product : productService.getAllProducts()) {
                            System.out.println(product.toString());
                        }
                        if (productService.getAllProducts().isEmpty()) {
                            System.out.println("Products list is empty");
                        }
                        System.out.println("Press \"0\" to go back");
                        break;
                    case 2:
                        System.out.println("Enter product name ");
                        System.out.println(productService.getProductByName(productInput.getName()));
                        System.out.println("Press \"0\" to go back");
                        break;
                    case 3:
                        User user = getCurrentUser();
                        if (Objects.nonNull(user)) {
                            orderService.checkoutOrder(user.getId());
                            System.out.println("Product was added to your card");
                        } else {
                            System.out.println("No logged user");
                        }
                        showOptions(options);
                        System.out.println("Enter product's name you want to add to Order");
                        String name = productInput.getName();
                        orderService.addProductToOrder(name);
                        System.out.printf("Product %s added to cart%n", name);
                        System.out.println("Add another product enter 3, checkout 4");
                        System.out.println("Press \"0\" to go back");
                        break;
                    case 4:
                        if (isUserHasOrder()) {
                            orderService.checkoutOrder(getCurrentUser().getId());
                            System.out.println("Order was saved");
                        } else {
                            System.out.println("This user haven't made any orders yet");
                        }
                        showOptions(options);
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
            new ProductMenu().show();
        } catch (InputMismatchException i) {
            System.out.println(PLEASE_CHOOSE_NUMBER_FROM_MENU);
            new ProductMenu().show();
        }
    }

    @Override
    public void close() {
        new UserMenu().show();
    }

    private boolean isUserHasOrder() {
        User user = getCurrentUser();
        List<Order> orders = orderService.getAllOrdersForCurrentUser(user.getId());
        return !orders.isEmpty();
    }

    private User getCurrentUser () {
        return UserSession.getInstance().getUser();
    }

}