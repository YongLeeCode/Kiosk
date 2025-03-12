import cart.Cart;
import enums.Category;
import io.Input;
import io.Output;
import menu.Menu;
import menu.MenuItem;

import java.util.List;

public class Kiosk {
    Input input = new Input();
    Output output = new Output();
    Category category;
    Cart cart = new Cart();

    public void start() {
        Menu menu = new Menu();
        int end = 0;

        while (end != 1) {
            //메뉴 출력 및 선택
            output.displayMainMenu();
            output.displayOrderMenu(cart.getOrderQuantity());
            try {
                category = Category.fromCategoryNumber(input.getNumber(), cart.getOrderQuantity());
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                continue;
            }

            if (category.getCategory().equals("Exit")) {
                end = 1;
            } else if (category.getCategory().equals("Order")) {
                end = orderProcess();
            } else if (category.getCategory().equals("Cancel")) {
                cart.removeCart();
                output.displayClearCart();
            } else {
                addToCartProcess(menu);
            }

        }
        output.displayResult(cart.getTotal());
    }

    private int orderProcess() {
        output.displayCartItems(cart.getItemsFromCart());
        System.out.println("1. 주문        2. 메뉴판");
        output.displayTotalPrice(cart.getTotal());
        return input.getOrderDecision();
    }

    private void addToCartProcess(Menu menu) {
        //아이템 출력 및 선택
        List<MenuItem> items = menu.getItems(category);
        output.displayMenuItems(category.getCategory(), items);
        int itemSelection = input.getItemNumber(menu.getItemsLength(category));
        if (itemSelection != 0) {
            output.displayOrder(menu.getItem(category, itemSelection));
            System.out.println("이 메뉴를 장바구니에 넣으시겠습니까?");
            System.out.println("1. 확인        2. 취소");
            if(input.getOrderDecision() == 1) {
                cart.addToCart(menu.getItem(category, itemSelection));
                output.displayCartItems(cart.getItemsFromCart());
            }
        }
    }
}