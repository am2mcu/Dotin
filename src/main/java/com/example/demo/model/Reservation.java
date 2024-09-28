package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "reservation_sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reservation_sequence"
    )
    private Long reservationId;

    @OneToOne
    @JoinColumn(name = "room_id")
    private Room room;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Reservation(Room room, User user) {
        this.room = room;
        this.user = user;
    }
}
