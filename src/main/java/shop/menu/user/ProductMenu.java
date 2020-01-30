package shop.menu.user;

import shop.entity.Product;
import shop.menu.Menu;
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
    private ProductService productService = new ProductServiceImpl();
    private OrderService orderService = new OrderServiceImpl();

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
                        break;
                    case 2:
                        System.out.println("Enter product name ");
                        String name = scanner.next();
                        try {
                            System.out.println(productService.getProductByName(name));
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 3:
                        System.out.println("Enter product's name you want to add to Order");
                        String productName = scanner.next();
                        orderService.addProductToOrder(productName);
                        System.out.println("Product " + productName + " added to cart");
                        System.out.println("Add another product enter 3, checkout 4");
                        break;
                    case 4:
                        orderService.checkoutOrder(UserSession.getInstance().getUser().get().getId());
                        System.out.println("Order was saved");
                        break;
                    case 0:
                        close();
                        break;
                    default:
                        showOptions(options);
                        break;
                }
            }
        } catch (InputMismatchException i) {
            System.out.println(PLEASE_CHOOSE_NUMBER_FROM_MENU);
            new ProductMenu().show();
        }
    }

    @Override
    public void close() {
        new UserMenu().show();
    }
}