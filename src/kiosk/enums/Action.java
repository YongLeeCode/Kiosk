package kiosk.enums;

/**
 * packageName    : kiosk.enums
 * fileName       : Action
 * author         : yong
 * date           : 3/14/25
 * description    : User가 어떤 동작을 할지 선택할 수 있는 액션을 정의하긴 위한 enum 클래스
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/14/25        yong       최초 생성
 */
public enum Action {
    ORDER(1, "Order"),
    PURCHASE(2, "Purchase"),
    CANCEL(3, "Cancel"),
    EXIT(0, "Exit");

    private final int actionNumber;
    private final String actionName;

    public final static int SIZE = 3;

    Action(int actionNumber, String actionName) {
        this.actionNumber = actionNumber;
        this.actionName = actionName;
    }

    public int getActionNumber() {
        return this.actionNumber;
    }

    public String getActionName() {
        return this.actionName;
    }

    public static Action fromActionNumber(int actionNumber) {
        for(Action action : values()) {
            if(action.actionNumber == actionNumber) {
                return action;
            }
        }
        throw new IndexOutOfBoundsException("선택사항에 없는 번호입니다.");
    }
}
