package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
@Tag(name = "reservation", description = "List & Modify reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @Operation(
            summary = "Get reservations",
            description = "Get all reserved rooms properties"
    )
    @GetMapping()
    public List<Reservation> getReservedRooms() {
        return reservationService.getReservations();
    }
}
