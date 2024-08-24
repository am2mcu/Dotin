package mohammad.application.rule;

import mohammad.data.storage.Base;
import mohammad.presentation.InputManager;
import mohammad.presentation.Message;
import mohammad.presentation.Panel;

public class ReserveManagerHandler implements Rule{

    Panel panel;
    InputManager inputManager;
    boolean notEOF;
    Message message;
    Base base;

    public ReserveManagerHandler(Base base) {
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
            runReserveManager();
        } while (notEOF);
    }

    private void runReserveManager() {
        message.showReserveManagerPanel();
        switch (inputManager.getChoiceInput()) {
            case 1 -> doGetRequestList();
            case 2 -> doAckOrNakToRequest();
            case 3 -> doEOF();
            default -> message.showInvalidChoiceMessage();
        }
    }

    private void doGetRequestList() {
        System.out.println("doGetRequestList"); // TODO doGetRequestList
    }

    private void doAckOrNakToRequest() {
        System.out.println("doAckOrNakToRequest"); // TODO doAckOrNakToRequest
    }

    private void doEOF() {
        notEOF = false;
    }
}
