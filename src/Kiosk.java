import enums.Category;
import io.Input;
import io.Output;
import menu.Menu;
import menu.MenuItem;

import java.util.List;

public class Kiosk {
    Input input = new Input();
    Output output = new Output();
    Category category;

    public void start() {
        Menu menu = new Menu();

        while (true) {
            //메뉴 출력 및 선택
            output.displayMenus();
            try {
                category = Category.fromCategoryNumber(input.getNumber());
                if(category.getCategory().equals("Exit")) {
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
                continue;
            }
            //아이템 출력 및 선택
            List<MenuItem> items = menu.getItems(category);
            output.displayMenuItems(category.getCategory(), items);
            int itemSelection = input.getItemNumber(menu.getItemsLength(category));
            if(itemSelection == 0) {
                continue;
            }
            output.displayOrder(menu.getItem(category, itemSelection));


            System.out.println();
        }
    }
}