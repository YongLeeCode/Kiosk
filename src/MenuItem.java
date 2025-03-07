import java.util.List;

public class MenuItem {
    // ShackBurger, 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거
    private String name;
    private double price;
    private List<String> explanation;

    public MenuItem(String name, double price, List<String> explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }
}
