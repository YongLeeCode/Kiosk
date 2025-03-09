public class MenuItem {
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
