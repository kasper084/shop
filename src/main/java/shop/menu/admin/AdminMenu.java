package shop.menu.admin;

import shop.menu.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu implements Menu {

    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    @Override
    public void addOptions() {
        options.add("1. Block/Unblock user");
        options.add("2. Order menu");
        options.add("3. Products menu");
        options.add("0. Exit");
    }

    @Override
    public void show() {

    }

    @Override
    public void close() {

    }
}