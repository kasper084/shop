package shop.menu;

import java.util.Scanner;

public class CredentialsMenu {
    private Scanner scanner = new Scanner(System.in);

    public String getEmail() {
        int retryCount = 3;
        System.out.println("Enter email");
        String email = scanner.nextLine();
        while (!isEmailValid(email)) {
            retryCount--;
            if (retryCount != 0) {
                System.out.println("Invalid format. Try again" +
                        "\nNumber of tries left:"
                        + retryCount);
                email = scanner.nextLine();
            } else {
                throw new IllegalArgumentException(EMAIL_FORMAT_WRONG );
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