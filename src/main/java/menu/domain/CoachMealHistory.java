package menu.domain;

import java.util.*;

public class CoachMealHistory {
    private final Map<String, List<String>> coachMealHistory = new HashMap<>();

    public boolean isPossibleMenu(String coachName, String menu) {
        if (coachMealHistory.containsKey(coachName)) {
            List<String> menuHistory = coachMealHistory.get(coachName);
            return !menuHistory.contains(menu);
        }
        return true;
    }

    public void mealMenu(String coachName, String menu) {
        if (coachMealHistory.containsKey(coachName)) {
            List<String> menuHistory = coachMealHistory.get(coachName);
            menuHistory.add(menu);
            return;
        }
        coachMealHistory.put(coachName, new ArrayList<>(List.of(menu)));
    }

    public List<String> getRecommendedMenuPerCoach(String coachName) {
        return new ArrayList<>(coachMealHistory.get(coachName));
    }
}
