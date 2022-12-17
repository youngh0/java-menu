package menu.domain;

import java.util.EnumMap;

public class CategoryMealHistory {
    private final EnumMap<CategoryMenu, Integer> categoryHistory = new EnumMap<>(CategoryMenu.class);

    public boolean isPossibleCategory(CategoryMenu category) {
        Integer mealCount = categoryHistory.getOrDefault(category, 0);
        return mealCount < 2;
    }

    public void mealCategory(CategoryMenu categoryMenu) {
        categoryHistory.put(categoryMenu, categoryHistory.getOrDefault(categoryMenu, 0) + 1);
    }
}
