package io;


import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public int getNumber() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("메뉴: 번호만 입력 가능합니다.");
            scanner.nextLine();
            return getNumber();
        }
    }

}
