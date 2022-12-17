package menu.service;

import menu.domain.CategoryMealHistory;
import menu.domain.CategoryMenu;
import menu.util.CategorySelector;

public class MenuService {
    private final CategoryMealHistory categoryMealHistory = new CategoryMealHistory();
    private final CategorySelector categorySelector = new CategorySelector();

    public void recommendMenu() {
        CategoryMenu category = findPossibleCategory();
    }

    private CategoryMenu findPossibleCategory() {
        CategoryMenu category = categorySelector.pickCategory();
        if (categoryMealHistory.isPossibleCategory(category)) {
            return category;
        }
        return findPossibleCategory();
    }
}
