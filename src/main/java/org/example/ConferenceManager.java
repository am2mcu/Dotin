package org.example;

import java.util.ArrayList;
import java.util.Collection;

public class ConferenceManager {
    private static final ConferenceManager SINGLETON = new ConferenceManager();
    private final RoomHandler roomHandler = RoomHandler.getSINGLETON();

    private ConferenceManager() {
    }

    public static ConferenceManager getSingleton() {
        return SINGLETON;
    }

    public Collection<Room> getRooms() {
        return roomHandler.getRooms();
    }

    public void addRoom(int id, double price, int capacity) {
        roomHandler.addRoom(new Room(id, price, capacity));
    }
}
