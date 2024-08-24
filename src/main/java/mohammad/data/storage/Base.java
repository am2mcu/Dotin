package mohammad.data.storage;

import mohammad.data.model.Request;
import mohammad.data.model.Room;
import mohammad.data.model.User;

import java.util.ArrayList;

public interface Base {
    void storeUser(User user);

    void storeUser(ArrayList<User> users);

    void storeRoom(Room room);

    void storeRoom(ArrayList<Room> rooms);

    void storeRequest(Request request);

    void storeRequest(ArrayList<Request> requests);

    ArrayList<User> retrieveUser();

    User retrieveUser(int id);

    ArrayList<Room> retrieveRoom();

    Room retrieveRoom(int id);

    ArrayList<Request> retrieveRequest();

    Request retrieveRequest(int id);
}
