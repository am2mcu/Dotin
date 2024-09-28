package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "rooms")
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class Room {
    @Id
    @SequenceGenerator(
            name = "room_sequence",
            sequenceName = "room_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "room_sequence"
    )
    private Long roomId;
    @Transient
    private int roomNumber;
    private int capacity;

    private String status;

    public Room(int capacity, String status) {
        this.capacity = capacity;
        this.status = status;
    }

    public Integer getRoomNumber() {
        return (int) (100 + this.roomId);
    }
}
