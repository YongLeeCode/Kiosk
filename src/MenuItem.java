public class MenuItem {
    private String name;
    private double price;
    private String detail;

    public MenuItem(String name, double price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
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
