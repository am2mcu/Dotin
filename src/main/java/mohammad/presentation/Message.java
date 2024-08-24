package mohammad.presentation;

public class Message {
    Panel panel = new Panel();

    public void showExceptionMessage() {
        System.out.println("Some exception occurred!");
    }

    public void showQuitMessage() {
        System.out.println("Quit");
    }

    public void showInvalidRuleMessage() {
        System.out.println("Invalid rule selected!");
    }

    public void showWelcomePanel() {
        System.out.println(panel.getWelcomePanel());
    }

    public void showCustomerPanel() {
        System.out.println(panel.getCustomerPanel());
    }

    public void showSystemManagerPanel() {
        System.out.println(panel.getSystemManagerPanel());
    }

    public void showReserveManagerPanel() {
        System.out.println(panel.getReserveManagerPanel());
    }

    public void showInvalidChoiceMessage() {
        System.out.println("Invalid choice selected!");
    }
}
