package shop.menu.admin;

import java.util.Scanner;

public class OrderIdInput {
    private Scanner scanner = new Scanner(System.in);
    public String getOrderId(){ System.out.println("Enter ID"); return scanner.nextLine();}
}
