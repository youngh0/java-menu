package menu.view;

public class OutputView {
    private final String START_MESSAGE = "점심 메뉴 추천을 시작합니다.";
    private final String FORBIDDEN_MESSAGE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printSetForbiddenMenu(String coachName) {
        System.out.println(String.format(FORBIDDEN_MESSAGE, coachName));
    }
}
