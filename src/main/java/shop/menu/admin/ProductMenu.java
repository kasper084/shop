package shop.menu.admin;

import shop.entity.Product;
import shop.menu.Menu;
import shop.service.ProductService;
import shop.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private ProductService productService = new ProductServiceImpl();


    @Override
    public void addOptions() {
        options.add("1. Edit product details");
        options.add("2. Add new product");
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
                        System.out.println("Select product for update: ");
                        System.out.println("Enter name or leave empty if no update: ");
                        String newName = scanner.nextLine();
                        System.out.println("Enter price or leave empty if no update: ");
                        Double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter description or leave empty if no update: ");
                        String newDescription = scanner.nextLine();
                        productService.editProduct(newName, newPrice, newDescription);
                        System.out.println("Your updated product is: " + newName + ", "+ newPrice + ", "+ newDescription);
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
                        System.out.println("You added product: " + name + ", "+price + ", "+ description);
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
            System.out.println("Please choose the number from the menu");
            new ProductMenu().show();
        }
    }

    @Override
    public void close() {
        new AdminMenu().show();
    }
}