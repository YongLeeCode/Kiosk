import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> items;

    public Menu(String category, List<MenuItem> items) {
        this.category = category;
        this.items = items;
    }

    public MenuItem getItem(int itemNumber) {
        return items.get(itemNumber - 1);
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public String getCategory() {
        return category;
    }
}
