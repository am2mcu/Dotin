package mohammad.data.model;

import lombok.ToString;

@ToString
public class Room {
    int id;
    String number;
    double pricePerHour;
    int capacity;
    boolean available;
}
