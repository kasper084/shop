package shop.menu.admin;

import shop.entity.Product;
import shop.menu.Menu;
import shop.service.ProductService;
import shop.service.impl.ProductServiceImpl;

import java.util.*;

import static shop.ExceptionMessages.PLEASE_CHOOSE_NUMBER_FROM_MENU;

public class ProductMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private ProductService productService = new ProductServiceImpl();

    @Override
    public void addOptions() {
        options.add("1. Edit product details");
        options.add("2. Add new product");
        options.add("3. Show products");
        options.add("0. Go back");
    }

    @Override
    public void show() {
        addOptions();
        showOptions(options);
        try {
            while (true) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        try {
                            System.out.println("Select product for update: ");
                            String name = scanner.nextLine();
                            Product product = productService.getProductByName(name);
                            System.out.println("Enter new name or leave empty if no update: ");
                            String newName = scanner.nextLine();
                            System.out.println("Enter new price or leave 0 if no update: ");
                            Double newPrice = scanner.nextDouble();
                            scanner.nextLine();
                            System.out.println("Enter new description or leave empty if no update: ");
                            String newDescription = scanner.nextLine();
                            productService.editProduct(product, newName, newPrice, newDescription);
                            System.out.println("Your updated product is: " + product.getName() + ", " + product.getPrice() + ", " + product.getDescription());
                        } catch (NoSuchElementException e) {
                            System.out.println(e.getMessage());
                            showOptions(options);
                        }
                        break;
                    case 2:
                        System.out.println("Add name for new product: ");
                        String name = scanner.nextLine();
                        System.out.println("Add price for new product: ");
                        Double price = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Add description for new product: ");
                        String description = scanner.nextLine();
                        productService.addProduct(name, price, description);
                        System.out.println("You added new product: " + name + ", " + price + ", " + description);
                        break;
                    case 3:
                        for (Product product : productService.getAllProducts()) {
                            System.out.println(product.toString());
                        }
                        if (productService.getAllProducts().isEmpty()) {
                            System.out.println("Products list is empty");
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
        } catch (InputMismatchException i) {
            System.out.println(PLEASE_CHOOSE_NUMBER_FROM_MENU);
            new ProductMenu().show();
        }
    }

    @Override
    public void close() {
        new AdminMenu().show();
    }
}