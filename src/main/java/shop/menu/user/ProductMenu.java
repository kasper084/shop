package shop.menu.user;

import shop.menu.Menu;
import shop.service.ProductService;
import shop.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private ProductService productService = new ProductServiceImpl();
    //privet OrderService orderService = new OrderService();

    @Override
    public void addOptions() {
        options.add("1. Product list");
        options.add("2. Search for specific product");
        options.add("3. Add specific product to order");
        options.add("4. Order checkout");
        options.add("0. Go back");
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);

        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    productService.getAllProducts();
                    break;
                case 2:
                    productService.getProductByName(scanner.nextLine());
                    break;
                case 3:
                    //orderService.addSpecificProduct(productId);
                    break;
                case 4:
                    //orderService.checkout(orderId);
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
        new UserMenu().show();
    }
}