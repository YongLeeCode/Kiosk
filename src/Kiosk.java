import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    Scanner scanner = new Scanner(System.in);

    public void start() {
        List<MenuItem> items = new ArrayList<>();
        items.add(new MenuItem(1, "ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem(2, "SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        items.add(new MenuItem(3,"Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        items.add(new MenuItem(4, "Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        int choice = 1;
        while (choice != 0) {
            displayMenu(items);
            choice = scanner.nextInt();
            System.out.println(order(choice));
            System.out.println();
        }
    }

    private String order(int choice) {
        return switch (choice) {
            case 1 -> "선택된 메뉴 : ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거";
            case 2 -> "선택된 메뉴 : SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
            case 3 -> "선택된 메뉴 : Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
            case 4 -> "선택된 메뉴 : Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거";
            case 0 -> "프로그램을 종료합니다.";
            default -> "잘못된 입력입니다.";
        };
    }

    private void displayMenu(List<MenuItem> items) {
        System.out.println("[ SHAKESHACK MENU ]");
        items.stream().forEach(i ->
                System.out.printf("%d. %s | W %f | %s \n", i.getId(), i.getName(), i.getPrice(), i.getDetail())
        );
        System.out.println("0. 종료 \n");
    }
}