package menu.domain;

import java.util.List;
import java.util.Map;

public class CoachInfo {
    private Map<String, List<String>> coachNeverEatingMenus;
    private final List<String> coachNames;

    private final int MIN_NAME_LENGTH = 2;
    private final int MAX_NAME_LENGTH = 4;
    private final int MIN_COACH_NUMBER = 2;
    private final int MAX_COACH_NUMBER = 5;

    public CoachInfo(List<String> coachNames) {
        validate(coachNames);
        this.coachNames = coachNames;
    }

    private void validate(List<String> coachNames) {
        validateCoachNumber(coachNames);
        for (String coachName : coachNames) {
            validateNameLength(coachName);
        }
    }

    private void validateNameLength(String coachName) {
        if (coachName.length() < MIN_NAME_LENGTH || coachName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이가 허용 범위 밖입니다.");
        }
    }

    private void validateCoachNumber(List<String> coachNames) {
        if (coachNames.size() < MIN_COACH_NUMBER || coachNames.size() > MAX_COACH_NUMBER) {
            throw new IllegalArgumentException("코치는 2~5명 사이만 가능합니다.");
        }
    }
}