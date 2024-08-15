import java.util.Date;

public class Room {
    int id;
    int price;
    int capacity;
    boolean isReserved = false;
    Date startDate;
    Date endDate;

    public Room(int id, int price, int capacity) {
        this.id = id;
        this.price = price;
        this.capacity = capacity;
    }

    public void reserveRoom() {
        isReserved = true;

        startDate = new Date();
    }
}
