package shop.menu.input;

import java.util.Scanner;

import static shop.ExceptionMessages.EMAIL_FORMAT_WRONG;

public class CredentialsMenu {
    private Scanner scanner = new Scanner(System.in);

    public String getEmail() {
        int retryCount = 3;
        System.out.println("Enter email");
        String email = scanner.nextLine();
        while (!isEmailValid(email)) {
            retryCount--;
            if (retryCount != 0) {
                System.out.printf("Invalid format. Try again\nNumber of tries left:%d%n", retryCount);
                email = scanner.nextLine();
            } else {
                throw new IllegalArgumentException(EMAIL_FORMAT_WRONG);
            }
        }
        return email;
    }

    public String getPassword() {
        System.out.println("Enter password");
        return scanner.nextLine();
    }

    public String getName() {
        System.out.println("Enter name");
        return scanner.nextLine();
    }

    public String getPhone() {
        System.out.println("Enter phone number");
        return scanner.nextLine();
    }

    public boolean isEmailValid(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
}