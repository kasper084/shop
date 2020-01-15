package shop;

import shop.menu.LoginMenu;
import shop.menu.admin.UsersMenu;

public class App {
    public static void main(String[] args) {
/*        LoginMenu loginMenu = new LoginMenu();
        loginMenu.show();*/
        UsersMenu usersMenu = new UsersMenu();
        usersMenu.show();
    }
}