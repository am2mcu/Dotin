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
//@RequestMapping("rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @Tag(name = "room", description = "Access & modify rooms")
    @Operation(
            summary = "Get rooms",
            description = "Get all rooms properties",
            tags = {"room"}
    )
    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @Operation(
            summary = "Add room",
            description = "Add a new room",
            tags = {"room"}
    )
    @PostMapping("/rooms")
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @Operation(
            summary = "Delete room",
            description = "Delete an existing room",
            tags = {"room"}
    )
    @DeleteMapping("/rooms/{roomId}")
    public void deleteRoom(@PathVariable("roomId") Long roomId) {
        roomService.deleteRoom(roomId);
    }


    @Operation(
            summary = "Modify room",
            description = "Update a room properties",
            tags = {"room"}
    )
    @PutMapping("/rooms/{roomId}")
    public void updateRoom(
            @PathVariable("roomId") Long roomId,
            @RequestParam int capacity) {
        roomService.updateRoom(roomId, capacity);
    }

    @Tag(name = "reservation", description = "List & Modify reservations")
    @Operation(
            summary = "Get reservations",
            description = "Get all reserved rooms properties",
            tags = {"reservation"}
    )
    @GetMapping("/reservations")
    public List<Reservation> getReservedRooms() {
        return roomService.getReservedRooms();
    }

    @Tag(name = "reservation", description = "List & Modify reservations")
    @Operation(
            summary = "Reserve room",
            description = "Reserve a new room",
            tags = {"reservation"}
    )
    @PostMapping("/reservations/{roomId}")
    public void reserveRoom(@PathVariable("roomId") Long roomId) {
        roomService.reserveRoom(roomId);
    }
}
