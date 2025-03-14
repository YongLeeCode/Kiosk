package kiosk.menu;

import java.util.List;
import java.util.Map;

public class Menu {
    public static final int BURGER = 1;
    public static final int DRINK = 2;
    public static final int DESSERT = 3;

    private final List<MenuItem> burgers = List.of(
            new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"),
            new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"),
            new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"),
            new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")
    );

    private final List<MenuItem> drinks = List.of(
            new MenuItem("Coke", 1.3, "원조 역시 코카콜라지요~"),
            new MenuItem("Pepsi", 1.0, "영원한 2인자 펩시! 하지만?"),
            new MenuItem("Dr.peper", 1.2, "가끔씩 이게 땡기네요!"),
            new MenuItem("Sprint", 1.0, "무난하게 선택하기 좋죠.")
    );

    private final List<MenuItem> desserts = List.of(
            new MenuItem("Soft Ice Cream", 6.9, "버거를 먹으러 오면 소프트 아이스크림이 땡기지 않나요?"),
            new MenuItem("Cookie", 8.9, "있으면 계속 손이 가요~"),
            new MenuItem("Choco Chip", 6.9, "맛있어요"),
            new MenuItem("Coal slaw", 5.4, "중독 될거 같아요 ~.~")
    );

    Map<Integer, List<MenuItem>> menuCategory = Map.of(
            BURGER, burgers,
            DRINK, drinks,
            DESSERT, desserts
    );

    public List<MenuItem> getItems(int category) {
        return menuCategory.get(category);
    }

    public MenuItem getItem(int c, int item) {
        return getItems(c).get(item - 1);
    }

    public int getItemsLength(int c) {
        return getItems(c).size();
    }
}
