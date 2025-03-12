package cart;

import menu.MenuItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cart {
    private List<MenuItem> items = new ArrayList<>();
    private HashMap<MenuItem, Integer> mapItems = new HashMap<>();

    public void addToCart(MenuItem item) {
//        this.items.add(item);
        this.mapItems.put(item, this.mapItems.getOrDefault(item, 0) + 1);
    }

    public Integer getOrderQuantity() {
//        return items.size();
        int quantity = 0;
        for(MenuItem key : mapItems.keySet()) {
            quantity += mapItems.get(key);
        }
        return quantity;
    }

    public void getReceipt() {
        for(MenuItem key : mapItems.keySet()) {
            System.out.println(key.getName() + " " + key.getPrice() + " : " + mapItems.get(key));
        }
    }

    public List<MenuItem> getItemsFromCart() {
        return items;
    }

//    public HashMap<MenuItem, Integer> getItemsFromCartWithMap() {
//        return mapItems;
//    }

    public double getTotal() {
        return this.items.stream()
                .mapToDouble(i -> i.getPrice())
                .sum();
    }

}
