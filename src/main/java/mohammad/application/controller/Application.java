package mohammad.application.controller;

import mohammad.application.rule.CustomerHandler;
import mohammad.application.rule.ReserveManagerHandler;
import mohammad.application.rule.Rule;
import mohammad.application.rule.SystemManagerHandler;
import mohammad.data.storage.Base;
import mohammad.data.storage.MemoryBase;
import mohammad.presentation.InputManager;
import mohammad.presentation.Message;
import mohammad.presentation.Panel;

public class Application {

    boolean notEOF;
    Rule rule;
    Base base;
    Panel panel;
    Message message;
    InputManager inputManager;


    public Application() {
//        try {
        lunchProgram();
//        } catch (Exception e) {
//            showExceptionMessage();
//        } finally {
//            closeProgram();
//        }
    }


    private void lunchProgram() {
        initializeInstances();
        executeApplication();
    }

    private void showExceptionMessage() {
        message.showExceptionMessage();
    }

    private void closeProgram() {
        System.exit(0);
    }


    private void initializeInstances() {
        panel = new Panel();
        inputManager = new InputManager();
        message = new Message();
        base = new MemoryBase(); // TODO BaseFactory
        notEOF = true;
    }

    private void executeApplication() {
        do {
            runApplication();
        } while (notEOF);
    }


    private void runApplication() {
        selectRule();
        executeRule();
    }


    private void selectRule() {
        message.showWelcomePanel();
        switch (inputManager.getChoiceInput()) {
            case 1 -> rule = new CustomerHandler(base);
            case 2 -> rule = new SystemManagerHandler(base);
            case 3 -> rule = new ReserveManagerHandler(base);
            case 4 -> doEOF();
            default -> message.showInvalidRuleMessage();
        }
    }

    private void doEOF() {
        message.showQuitMessage();
        closeProgram();
    }

    private void executeRule() {
        rule.execute();
    }

}
