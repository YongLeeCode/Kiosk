package kiosk;

import kiosk.cart.Cart;
import kiosk.enums.Action;
import kiosk.enums.Discount;
import kiosk.io.Input;
import kiosk.io.Output;
import kiosk.menu.Menu;
import kiosk.menu.MenuItem;

import java.util.List;
import java.util.Map;

/**
 * @packageName    : kiosk
 * @fileName       : Kiosk
 * @author         : yong
 * @date           : 3/13/25
 * @description    : 키오스크의 모든 프로세스를 담당하는 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/13/25        yong       최초 생성
 */
public class Kiosk {
    public static final int PURCHASE = 2;
    private static final int MOVE_PREVIOUS = 0;
    public static final int EXIT = 0;
    private final int YES = 2;

    //클래스
    Input input;
    Output output;
    Cart cart;
    Menu menu;
    //enum
    Discount discount;
    Action action;


    public Kiosk() {
        this.input = new Input();
        this.output = new Output();
        this.cart = new Cart();
        this.menu = new Menu();
    }

    public void start() {
        int kiosk = 10;
        while (kiosk != Action.EXIT.getActionNumber() && kiosk != Action.PURCHASE.getActionNumber()) {
            if(cart.isCartEmpty()) {
                action = Action.ORDER;
            } else {
                try {
                    output.displayOrderMenu();
                    action = Action.fromActionNumber(input.getNumber());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }

            switch (action) {
                case EXIT : kiosk = EXIT; break;
                case PURCHASE : kiosk = movePurchasingProcess(); break;
                case CANCEL : cancelProcess(); break;
                case ORDER : addToCartProcess(menu); break;
                default :  break;
            }
        }

        switch (kiosk) {
            case EXIT -> System.out.println("키오스크를 종료합니다.");
            case PURCHASE -> output.displayResult(cart.getTotal(discount.getDiscountRatio()));
            default -> throw new RuntimeException();
        }
    }

    private int movePurchasingProcess() {
        output.displayCartItems(cart.getItemsFromCart());
        System.out.println("1. 구매        2. 주문 이어서 하기");
        int purchaseDecision = input.getYesOrNo();
        if(purchaseDecision == Action.PURCHASE.getActionNumber()) {
            return moveDiscountProcess();
        }
        return purchaseDecision;
    }

    private int moveDiscountProcess() {
        output.displayDiscount(Discount.values());
        try {
            return switch (input.getItemNumber(Discount.SIZE)) {
                case 1 -> {
                    discount = Discount.NATIONAL_MERITORIOUS_PERSON;
                    yield Action.PURCHASE.getActionNumber();
                }
                case 2 -> {
                    discount = Discount.SOLDIER;
                    yield Action.PURCHASE.getActionNumber();
                }
                case 3 -> {
                    discount = Discount.STUDENT;
                    yield Action.PURCHASE.getActionNumber();
                }
                case 4 -> {
                    discount = Discount.COMMON;
                    yield Action.PURCHASE.getActionNumber();
                }
                case 0 -> Action.CANCEL.getActionNumber();
                default -> throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.\n다시 입력해주세요.");
            };
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return moveDiscountProcess();
        }
    }

    private void addToCartProcess(Menu menu) {
        output.displayMainMenu();
        int menuChoice = input.getItemNumber(Action.SIZE);

        //아이템 출력 및 선택
        List<MenuItem> items = menu.getItems(menuChoice);
        output.displayMenuItems(items);
        int itemSelection = input.getItemNumber(menu.getItemsLength(menuChoice));
        if (itemSelection != MOVE_PREVIOUS) {
            output.displayOrder(menu.getItem(menuChoice, itemSelection));
            System.out.println("이 메뉴를 장바구니에 넣으시겠습니까?");
            System.out.println("1. 확인        2. 취소");

            if (input.getYesOrNo() == YES) {
                cart.addToCart(menu.getItem(menuChoice, itemSelection));
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
