package org.example;

import java.util.Collection;

public class ConferenceManager {
    private static final ConferenceManager SINGLETON = new ConferenceManager();
    private final RoomHandler roomHandler = RoomHandler.getSINGLETON();
    private final CustomerHandler customerHandler = CustomerHandler.getSINGLETON();

    private ConferenceManager() {
    }

    public static ConferenceManager getSingleton() {
        return SINGLETON;
    }

    public Collection<Room> getRooms() {
        return roomHandler.getRooms();
    }

    // TODO: Admin interface - place in AdminPanel
    public void addRoom(int id, double price, int capacity) {
        roomHandler.addRoom(new Room(id, price, capacity));
    }

    public void createAccount(String id, String firstName, String lastName, String phoneNumber, String email) {
        customerHandler.addCustomer(new Customer(id, firstName, lastName, phoneNumber, email));
    }
}
