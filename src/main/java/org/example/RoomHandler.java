package org.example;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RoomHandler {
    private static final RoomHandler SINGLETON = new RoomHandler();
    private final Map<Integer, Room> roomMap = new HashMap<>();

    private RoomHandler() {
    }

    public static RoomHandler getSINGLETON() {
        return SINGLETON;
    }

    public Collection<Room> getRooms() {
        return roomMap.values();
    }

    public void addRoom(Room room) {
        roomMap.put(room.getId(), room);
    }
}
