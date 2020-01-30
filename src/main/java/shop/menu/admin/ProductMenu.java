package shop.menu.admin;

import shop.entity.Product;
import shop.menu.Menu;
import shop.menu.input.ProductInput;
import shop.service.ProductService;
import shop.service.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static shop.ExceptionMessages.PLEASE_CHOOSE_NUMBER_FROM_MENU;

public class ProductMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();
    private ProductInput productInput = new ProductInput();
    private ProductService productService = new ProductServiceImpl();

    @Override
    public void addOptions() {
        options.add("1. Edit product details");
        options.add("2. Add new product");
        options.add("3. Delete product");
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
                        System.out.println("Enter name of product you want to change");
                        List<Product> editProductList = productService.getAllProducts();
                        for (Product product : editProductList) {
                            System.out.println(product);
                        }
                        productService.getProductByName(productInput.getName());
                        String newName = productInput.getName();
                        System.out.println("Enter new price or leave 0 if no update: ");
                        Double newPrice = productInput.getPrice();
                        System.out.println("Enter new description or leave empty if no update: ");
                        String newDescription = productInput.getDescription();
                        productService.editProduct(newName, newPrice, newDescription);
                        System.out.printf("Your updated product is: %s, %s, %s%n",
                                newName, newPrice, newDescription);
                        showOptions(options);
                        break;
                    case 2:
                        System.out.println("Add name for new product: ");
                        String name = productInput.getName();
                        System.out.println("Add price for new product: ");
                        Double price = productInput.getPrice();
                        scanner.nextLine();
                        System.out.println("Add description for new product: ");
                        String description = productInput.getDescription();
                        productService.addProduct(name, price, description);
                        System.out.printf("You added new product: %s, %s, %s%n",
                                name, price, description);
                        showOptions(options);
                        break;
                    case 3:
                        System.out.println("Select product you want to delete: ");
                        List<Product> deleteProductList = productService.getAllProducts();
                        for (Product product : deleteProductList) {
                            System.out.println(product);
                        }
                        productService.deleteProduct(productInput.getName());
                        System.out.println("Product was deleted");
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
        new AdminMenu().show();
    }
}