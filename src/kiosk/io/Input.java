package kiosk.io;

import kiosk.enums.Action;
import kiosk.menu.MenuItem;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        try {
            int userChoice =  scanner.nextInt();
            scanner.nextLine();
            return userChoice;
        } catch (InputMismatchException e) {
            System.out.println("번호만 입력 가능합니다.");
            scanner.nextLine();
            return getNumber();
        }
    }

    public int getItemNumber(int size) {
        try {
            String input = scanner.nextLine();
            int userChoice = Integer.parseInt(input);

            if (userChoice >= 0 && userChoice <= size) {
                return userChoice;
            }
            throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.");
        } catch (NumberFormatException e) {
            System.out.println("번호만 입력 가능합니다.");
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            return getItemNumber(size);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            return getItemNumber(size);
        }
    }

    public int getYesOrNo() {
        try {
            String input = scanner.nextLine();
            int userChoice = Integer.parseInt(input);
            return switch (userChoice) {
                case 1 -> Action.PURCHASE.getActionNumber();
                case 2 -> Action.ORDER.getActionNumber();
                default -> throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.");
            };
        } catch (NumberFormatException e) {
            System.out.println("번호만 입력 가능합니다.");
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            return getYesOrNo();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("메뉴판에 있는 번호를 다시 선택해주세요.");
            return getYesOrNo();
        }
    }

    public MenuItem getCancelItem(Map<Integer, MenuItem> items) {
        try {
            int userChoice = scanner.nextInt();
            if(items.size() >= userChoice && userChoice >= 1) {
                return items.get(userChoice);
            }
            throw new IndexOutOfBoundsException("번호만 입력해주세요.");
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.out.println("숫자만 입력이 가능합니다.");
            System.out.println("제거할 상품을 다시 선택해주세요.");
            return getCancelItem(items);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            System.out.println("제거할 상품의 번호를 다시 선택해주세요.");
            return getCancelItem(items);
        }
    }
}

