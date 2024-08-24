package mohammad.data.storage;

import mohammad.data.model.Request;
import mohammad.data.model.Room;
import mohammad.data.model.User;

import java.util.ArrayList;

public class DataBase implements Base {
    @Override
    public void storeUser(User user) {

    }

    @Override
    public void storeUser(ArrayList<User> users) {

    }

    @Override
    public void storeRoom(Room room) {

    }

    @Override
    public void storeRoom(ArrayList<Room> rooms) {

    }

    @Override
    public void storeRequest(Request request) {

    }

    @Override
    public void storeRequest(ArrayList<Request> requests) {

    }

    @Override
    public ArrayList<User> retrieveUser() {
        return null;
    }

    @Override
    public User retrieveUser(int id) {
        return null;
    }

    @Override
    public ArrayList<Room> retrieveRoom() {
        return null;
    }

    @Override
    public Room retrieveRoom(int id) {
        return null;
    }

    @Override
    public ArrayList<Request> retrieveRequest() {
        return null;
    }

    @Override
    public Request retrieveRequest(int id) {
        return null;
    }
}
