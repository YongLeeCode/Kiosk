package io;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import enums.Discount;
import menu.MenuItem;

public class Output {
    public void displayMainMenu() {
        System.out.println("""
                \n-------------
                [ MENU ]
                1. Burgers
                2. Drinks
                3. Desserts
                0. 종료
                -------------""");
    }

    public void displayOrderMenu(boolean isCartEmpty) {
        if (!isCartEmpty) {
            System.out.println("""
            -------------
            [ Order Menu ]
            4. Order
            5. Cancel
            -------------
            """);
        }
    }

    public void displayTotalPrice(double total) {
        System.out.println("\n-------------");
        System.out.println("[ Total ]");
        System.out.println("W " + total);
        System.out.println("-------------");
    }

    public void displayCartItems(Map<MenuItem, Integer> items) {
        System.out.println("\n-------------");
        System.out.println("[ Orders ]");
        for (MenuItem key : items.keySet()) {
            System.out.printf("%s %.2f 수량: %d\n", key.getName(), key.getPrice(), items.get(key));
        }
        System.out.println("-------------");
    }

    public void displayMenuItems(String category, List<MenuItem> items) {
        System.out.println("\n-------------");
        System.out.printf("[ %s MENU ] \n", category);
        IntStream.range(0, items.size())
                .forEach(i -> {
                    MenuItem item = items.get(i);
                    System.out.printf("%d %s : %.2f | %s | \n", i + 1, item.getName(), item.getPrice(), item.getDetail());
                });
        System.out.println("0. 메인 메뉴로 돌아가기");
        System.out.println("-------------");
    }

    public void displayClearCart() {
        System.out.println("\n-------------");
        System.out.println("장바구니를 모두 비웠습니다.");
        System.out.println("-------------");
    }

    public void displayOrder(MenuItem burger) {
        System.out.println("\n-------------");
        System.out.printf("선택된 메뉴 : %-15s  | W %.2f | %s \n", burger.getName(), burger.getPrice(), burger.getDetail());
        System.out.println("-------------");
    }

    public void displayResult(double total) {
        System.out.println("\n-------------");
        System.out.printf("주문이 완료되었습니다. 금액은 W %.2f 입니다.\n", total);
        System.out.println("-------------");
    }

    public void displayDiscount(Discount[] discounts) {
        System.out.println("\n-------------");
        for(int i = 0; i < discounts.length; i++) {
            String name = discounts[i].getDiscountName();
            int percentage = discounts[i].getDiscountPercentage();
            System.out.printf("%d. %s : %d%% \n", i + 1, name, percentage);
        }
        System.out.println("-------------");
    }
}
