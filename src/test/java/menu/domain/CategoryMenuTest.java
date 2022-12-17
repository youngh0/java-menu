package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryMenuTest {

    @Test
    void validateMenuName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CategoryMenu.validateMenuName("바나나"));
    }

    @Test
    void 숫자에_맞는_카테고리_반환_테스트() {
        org.assertj.core.api.Assertions.assertThat(CategoryMenu.getCategory(1))
                .isEqualTo(CategoryMenu.JAPAN_FOOD);
    }
}