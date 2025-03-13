import cart.Cart;
import enums.Category;
import enums.Discount;
import io.Input;
import io.Output;
import menu.Menu;
import menu.MenuItem;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * packageName    : PACKAGE_NAME
 * fileName       : Kiosk2
 * author         : yong
 * date           : 3/13/25
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/13/25        yong       최초 생성
 */
public class Kiosk2 {
    private static final int MOVE_PREVIOUS = 0;
    public static final int EXIT = 0;
    public static final int ORDERED = 1;

    Input input = new Input();
    Output output = new Output();
    Category category;
    Discount discount;
    Cart cart = new Cart();

    public void start() {
        Menu menu = new Menu();
        int kiosk = 10;
        while (kiosk != EXIT) {
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
                case "Exit" : kiosk = EXIT; break;
                case "Order" : kiosk = orderProcess(); break;
                case "Cancel" : cancelProcess(); break;
                default : addToCartProcess(menu); break;
            }
        }

        output.displayResult(cart.getTotal(discount.getDiscountRatio()));
    }

    private int orderProcess() {
        output.displayCartItems(cart.getItemsFromCart());
        System.out.println("1. 주문        2. 메뉴판");
        int isOrder = input.getOrderDecision();
        if(isOrder == EXIT) {
            discountProcess();
        }
        return isOrder;
    }

    private void discountProcess() {
        output.displayDiscount(Discount.values());
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        try {
            switch (a) {
                case 1: discount = Discount.NATIONAL_MERITORIOUS_PERSON; break;
                case 2: discount = Discount.SOLDIER; break;
                case 3: discount = Discount.STUDENT; break;
                case 4: discount = Discount.COMMON; break;
                default: throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.\n다시 입력해주세요.");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            discountProcess();
        }
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
            if (input.getOrderDecision() == 1) {
                cart.addToCart(menu.getItem(category, itemSelection));
                output.displayCartItems(cart.getItemsFromCart());
            }
        }
    }

    private void cancelProcess() {
        Map<Integer, MenuItem> orderedItems = output.displayCartItemsForCancel(cart.getItemsFromCart());
        MenuItem selectedItem = input.getCancelItem(orderedItems);
        cart.removeCart(selectedItem);
        System.out.printf("정상적으로 '%s' 상품이 주문에서 제외되었습니다.\n", selectedItem.getName());
    }
}
