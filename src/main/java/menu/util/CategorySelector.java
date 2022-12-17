package menu.util;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.CategoryMenu;

public class CategorySelector {
    public CategoryMenu pickCategory() {
        return CategoryMenu.getCategory(Randoms.pickNumberInRange(1, 5));
    }
}