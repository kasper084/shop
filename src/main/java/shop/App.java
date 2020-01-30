package shop;

import shop.menu.LoginMenu;
import shop.menu.admin.OrderMenu;

public class App {
    public static void main(String[] args) {
//        LoginMenu loginMenu = new LoginMenu();
//        loginMenu.show();

        OrderMenu orderMenu = new OrderMenu();
        orderMenu.show();
    }
}