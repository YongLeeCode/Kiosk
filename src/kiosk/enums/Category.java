package kiosk.enums;

public enum Category {
    BURGERS(1, "Burgers"),
    DRINKS(2, "Drinks"),
    DESSERTS(3, "Desserts"),
    ORDER(4, "Order"),
    CANCEL(5, "Cancel"),
    EXIT(0, "Exit");

    private final int categoryNumber;
    private final String category;

    Category(int categoryNumber, String category) {
        this.category = category;
        this.categoryNumber = categoryNumber;
    }

    public String getCategory() {
        return category;
    }

    /**
     * 설명: 입력값을 Enum 클래스로 원하는 값으로 반환
     *
     * <p>{입력값에서 선택 가능한 숫자: 0~5}
     * @return Category 클래스 값으로 반환
     * @throws IndexOutOfBoundsException {0~5가 아닌 숫자가 온 경우}
     * @author Yong
     * @version 1.0
     * @메롱 hello
     * @since 2025-03-12
     */
    public static Category fromCategoryNumber(int categoryNumber, boolean isCartEmpty) {
        for (Category c : values()) {
            if (c.categoryNumber == categoryNumber) {
                if ((c == Category.ORDER || c == Category.CANCEL) && isCartEmpty) {
                    throw new IndexOutOfBoundsException("현재 선택할 수 없는 번호입니다.");
                }
                return c;
            }
        }
        throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.");
    }
}