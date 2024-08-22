package mohammad.application.controller;

import mohammad.application.rule.CustomerHandler;
import mohammad.application.rule.ReserveManagerHandler;
import mohammad.application.rule.Rule;
import mohammad.application.rule.SystemManagerHandler;
import mohammad.presentation.InputManager;
import mohammad.presentation.Panel;

public class Application {

    Panel panel;
    Rule rule;
    InputManager inputManager;


    public Application() {
        try {
            lunchProgram();
        } catch (Exception e) {
            showExceptionMessage();
        } finally {
            closeProgram();
        }
    }


    private void lunchProgram() {
        initializeInstances();
        showWelcomePanel();
        selectRule();
        executeRule();
    }

    private void showExceptionMessage() {
        System.out.println("Some exception occurred!");
    }

    private void closeProgram() {
        System.exit(0);
    }


    private void initializeInstances() {
        panel = new Panel();
        inputManager = new InputManager();
    }

    private void showWelcomePanel() {
        System.out.println(panel.getWelcomePanel());
    }

    private void selectRule() {
        switch (inputManager.getChoiceInput()) {
            case 1 -> rule = new CustomerHandler();
            case 2 -> rule = new SystemManagerHandler();
            case 3 -> rule = new ReserveManagerHandler();
            default -> showInvalidRuleMessage();
        }
    }

    private void executeRule() {
        rule.execute();
    }


    private void showInvalidRuleMessage() {
        System.out.println("Invalid rule selected!");
    }

}
