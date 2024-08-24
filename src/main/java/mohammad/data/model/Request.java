package mohammad.data.model;

import lombok.ToString;

@ToString
public class Request {
    int id;
    String from;
    String roomNumber;
    int hours;
    boolean status;
}
