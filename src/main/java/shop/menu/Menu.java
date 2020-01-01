package shop.menu;

public interface Menu {
    void showMenu();

    void closeMenu();

    default void printOptions(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
    }
}