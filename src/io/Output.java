package io;

import java.util.List;
import java.util.stream.IntStream;

import menu.MenuItem;

public class Output {
    public void displayMenus() {
        System.out.println("[ MENU ]");
        System.out.println("1. Burgers");
        System.out.println("2. Drinks");
        System.out.println("3. Desserts");
        System.out.println("0. 종료");
    }

    public void displayMenuItems(String category, List<MenuItem> items) {
        System.out.printf("\n[ %s MENU ] \n", category);
        IntStream.range(0, items.size())
                        .forEach(i -> {
                            MenuItem item = items.get(i);
                            System.out.printf("%d %s : %f | %s | \n", i + 1, item.getName(), item.getPrice(), item.getDetail());
                        });
        System.out.println("0. 메인 메뉴로 돌아가기");
    }

     public void displayOrder(MenuItem burger) {
        System.out.printf("선택된 메뉴 : %-15s  | W %f | %s \n", burger.getName(), burger.getPrice(), burger.getDetail());
    }
}
