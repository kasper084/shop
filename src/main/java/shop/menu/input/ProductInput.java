package shop.menu.input;

import java.util.Scanner;

public class ProductInput {
    private Scanner scanner = new Scanner(System.in);

    public String getName() {
        return scanner.nextLine();
    }

    public String getDescription() {
        return scanner.nextLine();
    }

    public Double getPrice() {
        return scanner.nextDouble();
    }
}
