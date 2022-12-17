package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CategoryMenuTest {

    @Test
    void validateMenuName() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> CategoryMenu.validateMenuName("바나나"));
    }
}