package cart;

import menu.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private HashMap<MenuItem, Integer> mapItems = new HashMap<>();

    public void removeCart() {
        mapItems = new HashMap<>();
    }

    public void addToCart(MenuItem item) {
        this.mapItems.put(item, this.mapItems.getOrDefault(item, 0) + 1);
    }

    public Integer getOrderQuantity() {
        int quantity = 0;
        for (MenuItem key : mapItems.keySet()) {
            quantity += mapItems.get(key);
        }
        return quantity;
    }

    public HashMap<MenuItem, Integer> getItemsFromCart() {
        return mapItems;
    }

    public double getTotal() {
        double total = 0;
        for (MenuItem item : mapItems.keySet()) {
            total += item.getPrice() * mapItems.get(item);
        }
        return total;
    }
}
