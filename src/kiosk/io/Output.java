package kiosk.io;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import kiosk.enums.Action;
import kiosk.enums.Discount;
import kiosk.menu.MenuItem;

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

    public void displayOrderMenu() {
        System.out.println("""
                -------------
                [ Choose Action ]
                """);
        System.out.printf("%d. %s \n", Action.ORDER.getActionNumber(), Action.ORDER.getActionName());
        System.out.printf("%d. %s \n", Action.PURCHASE.getActionNumber(), Action.PURCHASE.getActionName());
        System.out.printf("%d. %s \n", Action.CANCEL.getActionNumber(), Action.CANCEL.getActionName());
        System.out.printf("%d. %s \n", Action.EXIT.getActionNumber(), Action.EXIT.getActionName());
        System.out.println("-------------");

    }

    public void displayCartItems(Map<MenuItem, Integer> items) {
        System.out.println("\n-------------");
        System.out.println("[ Current Cart Status ]");
        for (MenuItem key : items.keySet()) {
            System.out.printf("%s %.2f 수량: %d\n", key.getName(), key.getPrice(), items.get(key));
        }
        System.out.println("-------------");
    }

    public void displayMenuItems(List<MenuItem> items) {
        System.out.println("\n-------------");
        System.out.printf("[ ORDER MENU ]\n");
        IntStream.range(0, items.size())
                .forEach(i -> {
                    MenuItem item = items.get(i);
                    System.out.printf("%d. %s : %.2f | %s | \n", i + 1, item.getName(), item.getPrice(), item.getDetail());
                });
        System.out.println("0. 메인 메뉴로 돌아가기");
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
        for (int i = 0; i < discounts.length; i++) {
            String name = discounts[i].getDiscountName();
            int percentage = discounts[i].getDiscountPercentage();
            System.out.printf("%d. %s : %d%% \n", i + 1, name, percentage);
        }
        System.out.println("0. 주문 이어서 하기");
        System.out.println("-------------");
    }

    public Map<Integer, MenuItem> displayCartItemsForCancel(Map<MenuItem, Integer> items) {
        Map<Integer, MenuItem> map = new HashMap<>();
        int i = 0;
        for (MenuItem item : items.keySet()) {
            i++;
            System.out.printf("%d. %s $%.2f quantity: %d \n", i, item.getName(), item.getPrice(), items.get(item));
            map.put(i, item);
        }
        System.out.println("주문에 제외하고 싶은 아이템의 번호를 선택하십시오: ");
        return map;
    }
}
