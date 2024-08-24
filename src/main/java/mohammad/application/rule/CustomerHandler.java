package mohammad.application.rule;

import mohammad.data.storage.Base;
import mohammad.presentation.InputManager;
import mohammad.presentation.Message;
import mohammad.presentation.Panel;

public class CustomerHandler implements Rule {

    Panel panel;
    InputManager inputManager;
    boolean notEOF;
    Message message;
    Base base;

    public CustomerHandler(Base base) {
        initializeInstances(base);
    }

    private void initializeInstances(Base base) {
        panel = new Panel();
        inputManager = new InputManager();
        message = new Message();
        notEOF = true;
        this.base = base;
    }


    @Override
    public void execute() {
        do {
            runCustomer();
        } while (notEOF);
    }

    private void runCustomer() {
        message.showCustomerPanel();
        switch (inputManager.getChoiceInput()) {
            case 1 -> doGetRoomList();
            case 2 -> doRequestForRoom();
            case 3 -> doGetRequestStates();
            case 4 -> doEOF();
            default -> message.showInvalidChoiceMessage();
        }
    }

    private void doGetRoomList() {
        System.out.println("doGetRoomList"); // TODO doGetRoomList
//        base.retrieveRoom().forEach(System.out::println);
    }

    private void doRequestForRoom() {
        System.out.println("doRequestForRoom"); // TODO doRequestForRoom
    }

    private void doGetRequestStates() {
        System.out.println("doGetRequestStates"); // TODO doGetRequestStates
    }

    private void doEOF() {
        notEOF = false;
    }

}
