import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        int choice = 1;
        List<MenuItem> burgers = new ArrayList<>();

        burgers.add(new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.add(new MenuItem(3, "Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.add(new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        while (choice != 0) {
            displayMenu(burgers);
            choice = scanner.nextInt();
            try {
                order(burgers.get(choice - 1));
            } catch (IndexOutOfBoundsException e) {
                System.out.println("잘못된 입력입니다.");
            }

            System.out.println();
        }
    }

    private void order(MenuItem burger) {
        System.out.printf("선택된 메뉴 : %-15s  | W %f | %s \n", burger.getName(), burger.getPrice(), burger.getDetail());
    }

    private void displayMenu(List<MenuItem> burgers) {
        System.out.println("[ SHAKESHACK MENU ]");
        for (int i = 0; i < burgers.size(); i++) {
            MenuItem burger = burgers.get(i);
            System.out.printf("%d. %-15s  | W %f | %s \n", burger.getId(), burger.getName(), burger.getPrice(), burger.getDetail());
        }
        System.out.println("0. 종료");
    }
}