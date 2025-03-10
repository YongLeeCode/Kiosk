import java.util.List;

public class Menu {
    private final String CETEGORY;
    private final List<MenuItem> ITEMS;

    public Menu(String category, List<MenuItem> items) {
        this.CETEGORY = category;
        this.ITEMS = items;
    }

    public MenuItem getItem(int itemNumber) {
        return ITEMS.get(itemNumber - 1);
    }

    public List<MenuItem> getItems() {
        return ITEMS;
    }

    public String getCategory() {
        return CETEGORY;
    }
}
