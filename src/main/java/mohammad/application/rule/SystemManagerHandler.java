package mohammad.application.rule;

import mohammad.data.storage.Base;
import mohammad.presentation.InputManager;
import mohammad.presentation.Message;
import mohammad.presentation.Panel;

public class SystemManagerHandler implements Rule {

    Panel panel;
    InputManager inputManager;
    boolean notEOF;
    Message message;
    Base base;

    public SystemManagerHandler(Base base) {
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
            runSystemManager();
        } while (notEOF);
    }

    private void runSystemManager() {
        message.showSystemManagerPanel();
        switch (inputManager.getChoiceInput()) {
            case 1 -> doGetRoomList();
            case 2 -> doAddRoom();
            case 3 -> doRemoveRoom();
            case 4 -> doEOF();
            default -> message.showInvalidChoiceMessage();
        }
    }

    private void doGetRoomList() {
        System.out.println("doGetRoomList"); // TODO doGetRoomList
    }

    private void doAddRoom() {
        System.out.println("doAddRoom"); // TODO doAddRoom
    }

    private void doRemoveRoom() {
        System.out.println("doRemoveRoom"); // TODO doRemoveRoom
    }

    private void doEOF() {
        notEOF = false;
    }
}
