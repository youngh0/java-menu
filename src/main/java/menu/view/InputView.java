package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.domain.CoachInfo;

import java.util.Arrays;

public class InputView {
    private final String INPUT_COACH_NAME_MESSAGE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public CoachInfo readCoachNames() {
        System.out.println(INPUT_COACH_NAME_MESSAGE);
        return new CoachInfo(Arrays.asList(Console.readLine().split(",")));
    }
}
