import cart.Cart;
import enums.Category;
import io.Input;
import io.Output;
import menu.Menu;
import menu.MenuItem;

import java.util.List;

public class Kiosk {
    private static int MOVE_PREVIOUS = 0;
    Input input = new Input();
    Output output = new Output();
    Category category;
    Cart cart = new Cart();

    public void start() {
        Menu menu = new Menu();
        boolean end = false;

        while (!end) {
            //메인 메뉴 출력
            output.displayMainMenu();
            output.displayOrderMenu(cart.isCartEmpty());
            try {
                category = Category.fromCategoryNumber(input.getNumber(), cart.isCartEmpty());
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                continue;
            }

            switch (category.getCategory()) {
                case "Exit" : end = true; break;
                case "Order" : end = orderProcess(); break;
                case "Cancel" : cart.removeCart(); output.displayClearCart(); break;
                default : addToCartProcess(menu); break;
            }
        }
        output.displayResult(cart.getTotal());
    }

    private boolean orderProcess() {
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
        if (itemSelection != MOVE_PREVIOUS) {
            output.displayOrder(menu.getItem(category, itemSelection));
            System.out.println("이 메뉴를 장바구니에 넣으시겠습니까?");
            System.out.println("1. 확인        2. 취소");
            if (input.getOrderDecision()) {
                cart.addToCart(menu.getItem(category, itemSelection));
                output.displayCartItems(cart.getItemsFromCart());
            }
        }
    }
}