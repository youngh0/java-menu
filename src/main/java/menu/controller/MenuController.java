package menu.controller;

import menu.domain.CoachInfo;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    public void run() {
        settingInfo();
    }

    private void settingInfo() {
        outputView.printStartMessage();
        CoachInfo coachInfo = settingCoachName();
        for (String coachName : coachInfo.getCoachNames()) {

            settingForbiddenFood(coachInfo, coachName);
        }
    }

    private CoachInfo settingCoachName() {
        try {
            return inputView.readCoachNames();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            return settingCoachName();
        }
    }

    private void settingForbiddenFood(CoachInfo coachInfo, String coachName) {
        try {
            outputView.printSetForbiddenMenu(coachName);
            coachInfo.initForbiddenFood(coachName, inputView.readForbiddenMenu());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR]");
            settingForbiddenFood(coachInfo, coachName);
        }
    }
}
