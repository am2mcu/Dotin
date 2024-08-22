package mohammad.presentation;

import java.util.Scanner;

public class InputManager {
    private final Scanner scanner;

    public InputManager() {
        scanner = new Scanner(System.in);
    }

    public int getChoiceInput() {
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }
}
