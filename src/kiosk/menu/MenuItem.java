package menu;

public class MenuItem {
    private final String NAME;
    private final double PRICE;
    private final String DETAIL;

    public MenuItem(String name, double price, String detail) {
        this.NAME = name;
        this.PRICE = price;
        this.DETAIL = detail;
    }

    public String getName() {
        return NAME;
    }

    public double getPrice() {
        return PRICE;
    }

    public String getDetail() {
        return DETAIL;
    }
}
