package shop.menu;

import java.util.List;

public interface Menu {

    void show();

    void close();

    default void showOptions (List<?> options) {
        for (Object option: options) {
            System.out.println(option);
        }
    }
}