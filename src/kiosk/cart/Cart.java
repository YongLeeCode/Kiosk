package kiosk.cart;

import kiosk.menu.MenuItem;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private final Map<MenuItem, Integer> mapItems = new HashMap<>();

    public void removeCart(MenuItem item) {
        mapItems.remove(item);
    }

    public void addToCart(MenuItem item) {
        this.mapItems.put(item, this.mapItems.getOrDefault(item, 0) + 1);
    }

    public boolean isCartEmpty() {
        return mapItems.isEmpty();
    }

    public Map<MenuItem, Integer> getItemsFromCart() {
        return mapItems;
    }

    public double getTotal(double discount) {
        double total = 0;
        for (MenuItem item : mapItems.keySet()) {
            total += item.getPrice() * mapItems.get(item);
        }
        return total * discount;
    }
}
