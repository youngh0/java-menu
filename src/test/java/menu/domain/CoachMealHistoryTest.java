package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CoachMealHistoryTest {
    CoachMealHistory coachMealHistory = new CoachMealHistory();
    @ParameterizedTest
    @CsvSource(value = {"영호,밥,false","영호,국,true"})
    void isPossibleMenu(String name, String menu, boolean result) {
        coachMealHistory.recommendMenu("영호","밥");
        Assertions.assertThat(coachMealHistory.isPossibleMenu(name, menu)).isEqualTo(result);
    }
}