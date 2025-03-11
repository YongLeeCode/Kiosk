package enums;

public enum Category {
    BURGERS(1, "Burgers"),
    DRINKS(2, "Drinks"),
    DESSERTS(3, "Desserts"),
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

    public static Category fromCategoryNumber(int categoryNumber) {
        for (Category c : values()) {
            if (c.categoryNumber == categoryNumber) {
                return c;
            }
        }
        throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.");
    }
}
