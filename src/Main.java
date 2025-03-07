import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice = 1;
        while (choice != 0) {
            System.out.println("""
                [ SHAKESHACK MENU ]
                1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
                2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
                3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
                4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
                0. 종료
                """);
            choice = scanner.nextInt();
            String result;
            switch (choice) {
                case 1 -> result = "선택된 메뉴 : ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거";
                case 2 -> result = "선택된 메뉴 : SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거";
                case 3 -> result = "선택된 메뉴 : Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거";
                case 4 -> result = "선택된 메뉴 : Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거";
                case 0 -> result = "프로그램을 종료합니다.";
                default -> result = "잘못된 입력입니다.";
            };
            System.out.println(result);
        }


    }
}