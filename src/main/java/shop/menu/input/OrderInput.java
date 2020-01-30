package shop.menu.input;

import java.util.Scanner;

public class OrderInput {
    private Scanner scanner = new Scanner(System.in);

    public String getOrderId() {
        System.out.println("Enter ID");
        return scanner.nextLine();
    }
}