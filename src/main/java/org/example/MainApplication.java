package org.example;

import java.util.Scanner;

public class MainApplication {
    private final ConferenceManager conferenceManager = ConferenceManager.getSingleton();
    public void run() {
        Scanner scanner = new Scanner(System.in);
        printMenu();

        conferenceManager.addRoom(100, 100.25, 2);
        conferenceManager.addRoom(101, 50, 1);
        for (Room room: conferenceManager.getRooms()) {
            System.out.println(room);
        }
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
