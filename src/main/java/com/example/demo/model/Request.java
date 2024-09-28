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
public class Request {
    @Id
    @SequenceGenerator(
            name = "sequence",
            sequenceName = "request_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence"
    )
    private Long requestId;

    @OneToOne
    private Room room;
    @OneToOne()
    private User user;

    public Request(Room room, User user) {
        this.room = room;
        this.user = user;
    }
}
