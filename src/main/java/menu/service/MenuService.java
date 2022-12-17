package menu.service;

import menu.domain.CategoryMealHistory;
import menu.domain.CategoryMenu;
import menu.domain.CoachInfo;
import menu.domain.CoachMealHistory;
import menu.util.CategorySelector;

import java.util.List;

public class MenuService {
    private final CategoryMealHistory categoryMealHistory = new CategoryMealHistory();
    private final CoachMealHistory coachMealHistory = new CoachMealHistory();
    private final CategorySelector categorySelector = new CategorySelector();

    public void recommendMenu(CoachInfo coachInfo) {
        int oneWeek = 5;
        while (oneWeek-- > 0) {
            CategoryMenu category = pickPossibleCategory();
            for (String coachName : coachInfo.getCoachNames()) {
                String menu = pickPossibleMenu(category, coachName, coachInfo);
                coachMealHistory.mealMenu(coachName, menu);
            }
            categoryMealHistory.saveCategoryInfoPerDay(category);
        }
    }

    public List<CategoryMenu> getRecommendedCategoryPerDay() {
        return categoryMealHistory.getCategoryRecommendedInfo();
    }

    public List<String> getRecommendedMenus(String coachName) {
        return coachMealHistory.getRecommendedMenuPerCoach(coachName);
    }

    private CategoryMenu findPossibleCategory() {
        CategoryMenu category = categorySelector.pickCategory();
        if (categoryMealHistory.isPossibleCategory(category)) {
            return category;
        }
        return findPossibleCategory();
    }

    private CategoryMenu pickPossibleCategory() {
        CategoryMenu category = findPossibleCategory();
        if (categoryMealHistory.isPossibleCategory(category)) {
            return category;
        }
        return pickPossibleCategory();
    }

    private String pickPossibleMenu(CategoryMenu category, String coachName, CoachInfo coachInfo) {
        String menu = categorySelector.pickMenu(category);
        if (coachMealHistory.isPossibleMenu(coachName, menu) && !coachInfo.isForbiddenMenu(coachName,menu)) {
            return menu;
        }
        return pickPossibleMenu(category, coachName, coachInfo);
    }
}
