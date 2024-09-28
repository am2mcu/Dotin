package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservation")
public class ReservationController {
    private final RoomService roomService;

    @Autowired
    public ReservationController(RoomService roomService) {
        this.roomService = roomService;
    }

    @Tag(name = "reservation", description = "List & Modify reservations")
    @Operation(
            summary = "Get reservations",
            description = "Get all reserved rooms properties",
            tags = {"reservation"}
    )
    @GetMapping()
    public List<Reservation> getReservedRooms() {
        return roomService.getReservedRooms();
    }

    @Operation(
            summary = "Reserve room",
            description = "Reserve a new room",
            tags = {"reservation"}
    )
    @PostMapping("/{roomId}")
    public void reserveRoom(@PathVariable("roomId") Long roomId) {
        roomService.reserveRoom(roomId);
    }
}
