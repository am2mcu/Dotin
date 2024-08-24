package mohammad.data.storage;

import mohammad.data.model.Request;
import mohammad.data.model.Room;
import mohammad.data.model.User;

import java.util.ArrayList;

public class MemoryBase implements Base {
    int generatedID;
    ArrayList<User> users;
    ArrayList<Room> rooms;
    ArrayList<Request> requests;

    public MemoryBase() {
        initializeInstances();
    }

    private void initializeInstances() {
        generatedID = 0;
        users = new ArrayList<>();
        rooms = new ArrayList<>();
        requests = new ArrayList<>();
    }

    @Override
    public void storeUser(User user) {
        users.add(user);
    }

    @Override
    public void storeUser(ArrayList<User> users) {
        this.users.addAll(users);
    }

    @Override
    public void storeRoom(Room room) {
        rooms.add(room);
    }

    @Override
    public void storeRoom(ArrayList<Room> rooms) {
        this.rooms.addAll(rooms);
    }

    @Override
    public void storeRequest(Request request) {
        requests.add(request);
    }

    @Override
    public void storeRequest(ArrayList<Request> requests) {
        this.requests.addAll(requests);
    }

    @Override
    public ArrayList<User> retrieveUser() {
        return users;
    }

    @Override
    public User retrieveUser(int id) {
        // TODO retrieveUser
        return null;
    }

    @Override
    public ArrayList<Room> retrieveRoom() {
        return rooms;
    }

    @Override
    public Room retrieveRoom(int id) {
        // TODO retrieveRoom
        return null;
    }

    @Override
    public ArrayList<Request> retrieveRequest() {
        return requests;
    }

    @Override
    public Request retrieveRequest(int id) {
        // TODO retrieveRequest
        return null;
    }
}
