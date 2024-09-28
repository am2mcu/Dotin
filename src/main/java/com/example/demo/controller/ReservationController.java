package com.example.demo.controller;

import com.example.demo.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Tag(name = "reservation", description = "List & Modify reservations")
    @Operation(
            summary = "Get reservations",
            description = "Get all reserved rooms properties",
            tags = {"reservation"}
    )
    @GetMapping()
    public List<Reservation> getReservedRooms() {
        return reservationService.getReservedRooms();
    }

    @Operation(
            summary = "Reserve room",
            description = "Reserve a new room",
            tags = {"reservation"}
    )
    @PostMapping("/{roomId}")
    public void reserveRoom(@PathVariable("roomId") Long roomId) {
        reservationService.reserveRoom(roomId);
    }
}
