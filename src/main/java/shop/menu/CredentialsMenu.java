package shop.menu;

import java.util.Scanner;

public class CredentialsMenu {
    private Scanner scanner = new Scanner(System.in);

    public String getEmail() {
        System.out.println("Enter email");
        String email = scanner.nextLine();
        if (!isEmailValid(email)) {
            System.out.println("Invalid format. Try again");
            getEmail();
        }
        return email;
    }

    public String getPassword() {
        System.out.println("Enter password");
        String password = scanner.nextLine();
        return password;
    }

    public String getName() {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        return name;
    }

    public String getPhone() {
        System.out.println("Enter phone number");
        String phoneNumber = scanner.nextLine();
        return phoneNumber;
    }

    public boolean isEmailValid(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}