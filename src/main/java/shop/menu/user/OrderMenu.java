package shop.menu.user;

import shop.menu.Menu;

public class OrderMenu implements Menu {


    @Override
    public void show() {

    }

    @Override
    public void close() {
        new UserMenu().show();
    }
}
