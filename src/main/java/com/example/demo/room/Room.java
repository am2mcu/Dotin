package com.example.demo.room;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
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

    public Room(int capacity) {
        this.capacity = capacity;
    }

    public Integer getRoomNumber() {
        return (int) (100 + this.roomId);
    }
}
