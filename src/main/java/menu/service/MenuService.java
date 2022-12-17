package menu.service;

import menu.domain.CategoryMealHistory;
import menu.domain.CategoryMenu;
import menu.domain.CoachInfo;
import menu.domain.CoachMenuRecommendInfo;
import menu.util.CategorySelector;

import java.util.List;

public class MenuService {
    private final CategoryMealHistory categoryMealHistory = new CategoryMealHistory();
    private final CoachMenuRecommendInfo coachMealHistory = new CoachMenuRecommendInfo();
    private final CategorySelector categorySelector = new CategorySelector();

    private final int DAY_COUNT = 5;

    public void recommendMenu(CoachInfo coachInfo) {
        int oneWeek = DAY_COUNT;
        while (oneWeek-- > 0) {
            CategoryMenu category = pickPossibleCategory();
            for (String coachName : coachInfo.getCoachNames()) {
                String menu = pickPossibleMenu(category, coachName, coachInfo);
                coachMealHistory.recommendMenu(coachName, menu);
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

    private CategoryMenu pickPossibleCategory() {
        CategoryMenu category = findPossibleCategory();
        if (categoryMealHistory.isPossibleCategory(category)) {
            return category;
        }
        return pickPossibleCategory();
    }

    private CategoryMenu findPossibleCategory() {
        CategoryMenu category = categorySelector.pickCategory();
        if (categoryMealHistory.isPossibleCategory(category)) {
            return category;
        }
        return findPossibleCategory();
    }

    private String pickPossibleMenu(CategoryMenu category, String coachName, CoachInfo coachInfo) {
        String menu = categorySelector.pickMenu(category);
        if (coachMealHistory.isPossibleMenu(coachName, menu) && !coachInfo.isForbiddenMenu(coachName,menu)) {
            return menu;
        }
        return pickPossibleMenu(category, coachName, coachInfo);
    }
}
