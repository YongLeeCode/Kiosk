package io;

import java.util.List;
import menu.Menu;
import menu.MenuItem;

public class Output {
    public void displayMenus() {
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        System.out.println("0. 종료");
    }

    public void displayMenuItems() {
        System.out.printf("[ %s MENU ] \n", menu.getCategory());
        for (int i = 0; i < menu.getItems().size(); i++) {
            MenuItem item = menu.getItems().get(i);
            System.out.printf("%d. %-15s  | W %f | %s \n", i + 1, item.getName(), item.getPrice(), item.getDetail());
        }
        System.out.println("0. 종료");
    }
}
