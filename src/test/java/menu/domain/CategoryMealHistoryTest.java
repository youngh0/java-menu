package menu.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class CategoryMealHistoryTest {
    CategoryMealHistory categoryMealHistory = new CategoryMealHistory();
    @ParameterizedTest
    @MethodSource("generateCategoryData")
    void isPossibleCategory(CategoryMenu category, boolean result) {
        categoryMealHistory.mealCategory(CategoryMenu.KOREA_FOOD);
        categoryMealHistory.mealCategory(CategoryMenu.KOREA_FOOD);
        Assertions.assertThat(categoryMealHistory.isPossibleCategory(category)).isEqualTo(result);
    }

    static Stream<Arguments> generateCategoryData() {
        return Stream.of(
                Arguments.of(CategoryMenu.ASIA_FOOD, true),
                Arguments.of(CategoryMenu.KOREA_FOOD, false)
        );
    }
}