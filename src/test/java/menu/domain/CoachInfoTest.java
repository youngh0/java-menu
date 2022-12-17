package menu.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class CoachInfoTest {
    @ParameterizedTest
    @MethodSource("generateWrongNameLengthData")
    void 코치_이름_길이_유효성_테스트(List<String> names) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CoachInfo(names));
    }

    @ParameterizedTest
    @MethodSource("generateWrongCoachNumberData")
    void 코치_인원_유효성_테스트(List<String> coachInfo) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CoachInfo(coachInfo));
    }

    static Stream<Arguments> generateWrongNameLengthData() {
        return Stream.of(
                Arguments.of(Arrays.asList("ab", "ba", "c")),
                Arguments.of(Arrays.asList("xa", "ya", "zqwer"))
        );
    }

    static Stream<Arguments> generateWrongCoachNumberData() {
        return Stream.of(
                Arguments.of(Arrays.asList("ab", "ba", "cr","ewr","qet","qert")),
                Arguments.of(List.of("xa"))
        );
    }
}