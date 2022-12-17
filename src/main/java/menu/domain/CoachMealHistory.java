package menu.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        }
        coachMealHistory.put(coachName, List.of(menu));
    }
}
