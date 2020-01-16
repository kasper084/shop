package shop.menu.admin;

import shop.menu.Menu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    //privet ProductService productService = new ProductService();

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
                        //productService.editProduct(productId);
                        break;
                    case 2:
                        //productService.add();
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