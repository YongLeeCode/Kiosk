import java.util.List;

public class MenuItem {
    // ShackBurger, 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거
    private int id;
    private String name;
    private double price;
    private String detail;

    public MenuItem(int id, String name, double price, String detail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }
}
