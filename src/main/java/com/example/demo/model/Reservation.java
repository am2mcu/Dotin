package com.example.demo.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "requests")
public class Reservation {
    @Id
    @SequenceGenerator(
            name = "sequence",
            sequenceName = "reservation_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence"
    )
    private Long reservationId;

    @OneToOne
    private Room room;
    @OneToOne
    private User user;

    public Reservation(Room room, User user) {
        this.room = room;
        this.user = user;
    }
}
