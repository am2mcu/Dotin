package org.example;

public class MainApplication {
    public void run() {
        printMenu();
    }
    public void printMenu() {
        System.out.println(
                "1. Display rooms\n" +
                "2. Admin panel\n" +
                "3. Exit\n\n" +
                "Select an option: "
        );
    }

    public static void main(String[] args) {
        new MainApplication().run();
    }
}
