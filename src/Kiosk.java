import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        int itemSelection = 1;
        int menuSelection = 1;

        List<MenuItem> burgers = new ArrayList<>();
        List<MenuItem> drinks = new ArrayList<>();
        List<MenuItem> desserts = new ArrayList<>();

        //burgers
        burgers.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        //drinks
        drinks.add(new MenuItem("Coke", 1.3, "원조 역시 코카콜라지요~"));
        drinks.add(new MenuItem("Pepsi", 1.0, "영원한 2인자 펩시! 하지만?"));
        drinks.add(new MenuItem("Dr.peper", 1.2, "가끔씩 이게 땡기네요!"));
        drinks.add(new MenuItem("Sprint", 1.0, "무난하게 선택하기 좋죠."));
        //desserts
        desserts.add(new MenuItem("Soft Ice Cream", 6.9, "버거를 먹으러 오면 소프트 아이스크림이 땡기지 않나요?"));
        desserts.add(new MenuItem("Cookie", 8.9, "있으면 계속 손이 가요~"));
        desserts.add(new MenuItem("Choco Chip", 6.9, "맛있어요"));
        desserts.add(new MenuItem("Coal slaw", 5.4, "중독 될거 같아요 ~.~"));

        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("Burger", burgers));
        menus.add(new Menu("Drink", drinks));
        menus.add(new Menu("Dessert", desserts));

        while (true) {
            //메뉴 출력 및 선택
            displayMenus(menus);
            try {
                menuSelection = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("메뉴: 번호만 입력 가능합니다.");
                scanner.nextLine();
                continue;
            }

            //아이템 출력
            try {
                if (menuSelection != 0) {
                    displayMenuItems(menus.get(menuSelection - 1));
                } else {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("선택 사항에 없는 번호입니다.");
                scanner.nextLine();
                continue;
            }

            // 아이템 선택
            try {
                itemSelection = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력 가능합니다.");
                scanner.nextLine();
                continue;
            }

            try {
                if (itemSelection != 0) {
                    MenuItem item = menus.get(menuSelection - 1).getItem(itemSelection);
                    // 선택한 아이템 출력
                    displayOrder(item);
                } else {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("선택 사항에 없는 번호입니다.");
                scanner.nextLine();
                continue;
            }


            System.out.println();
        }
    }

    private void displayMenus(List<Menu> menus) {
        for (int i = 0; i < menus.size(); i++) {
            Menu menu = menus.get(i);
            System.out.printf("%d. %s \n", i + 1, menu.getCategory());
        }
        System.out.println("0. 종료");
    }

    private void displayOrder(MenuItem burger) {
        System.out.printf("선택된 메뉴 : %-15s  | W %f | %s \n", burger.getName(), burger.getPrice(), burger.getDetail());
    }

    private void displayMenuItems(Menu menu) {
        System.out.printf("[ %s MENU ] \n", menu.getCategory());
        for (int i = 0; i < menu.getItems().size(); i++) {
            MenuItem item = menu.getItems().get(i);
            System.out.printf("%d. %-15s  | W %f | %s \n", i + 1, item.getName(), item.getPrice(), item.getDetail());
        }
        System.out.println("0. 종료");
    }
}