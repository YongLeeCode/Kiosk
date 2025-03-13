package kiosk.io;

import kiosk.Kiosk;
import kiosk.menu.MenuItem;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("번호만 입력 가능합니다.");
            scanner.nextLine();
            return getNumber();
        }
    }

    public int getItemNumber(int size) {
        try {
            int itemNumber = scanner.nextInt();
            if((itemNumber >= 1 && itemNumber <= size) || itemNumber == 0) {
                return itemNumber;
            }
            throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.");
        } catch (InputMismatchException e) {
            System.out.println("번호만 입력 가능합니다.");
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            scanner.nextLine();
            return getItemNumber(size);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            return getItemNumber(size);
        }
    }

    public int getOrderDecision() {
        try {
            return switch (scanner.nextInt()) {
                case 1 -> Kiosk.ORDER;
                case 2 -> Kiosk.MAIN_MENU;
                default -> throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.");
            };
        } catch (InputMismatchException e) {
            System.out.println("번호만 입력 가능합니다.");
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            scanner.nextLine();
            return getOrderDecision();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            return getOrderDecision();
        }
    }

    public MenuItem getCancelItem(Map<Integer, MenuItem> items) {
        return items.get(scanner.nextInt());
    }
}

