package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("reservations")
public class ReservationController {
    @Autowired
    private RoomService roomService;

    @Tag(name = "reservation", description = "List & Modify reservations")
    @Operation(
            summary = "Get reservations",
            description = "Get all reserved rooms properties",
            tags = {"reservation"}
    )
    @GetMapping()
    public List<Room> getReservedRooms() {
        return roomService.getReservedRooms();
    }
}
