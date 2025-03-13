package kiosk.enums;

/**
 * packageName    : kiosk.enums
 * fileName       : Discount
 * author         : yong
 * date           : 3/12/25
 * description    : 할인 혜택을 정의하는 클래스입니다.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/12/25        yong       최초 생성
 */
public enum Discount {
    NATIONAL_MERITORIOUS_PERSON(10, "국가유공자", 0.9),
    SOLDIER(5, "군인", 0.95),
    STUDENT(3,"학생", 0.97),
    COMMON(0, "일반", 1.0);

    private final int discountPercentage;
    private final String discountName;
    private final double discountRatio;

    Discount(int discountPercentage, String discountName, double discountRatio) {
        this.discountPercentage = discountPercentage;
        this.discountName = discountName;
        this.discountRatio = discountRatio;
    }

    public double getDiscountRatio() {
        return this.discountRatio;
    }

    public String getDiscountName() {
        return this.discountName;
    }

    public int getDiscountPercentage() {
        return this.discountPercentage;
    }
}
