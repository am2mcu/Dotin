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
@RequestMapping("rooms")
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
    @GetMapping()
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @Operation(
            summary = "Add room",
            description = "Add a new room",
            tags = {"room"}
    )
    @PostMapping()
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @Operation(
            summary = "Delete room",
            description = "Delete an existing room",
            tags = {"room"}
    )
    @DeleteMapping("/{roomId}")
    public void deleteRoom(@PathVariable("roomId") Long roomId) {
        roomService.deleteRoom(roomId);
    }


    @Operation(
            summary = "Modify room",
            description = "Update a room properties",
            tags = {"room"}
    )
    @PutMapping("/{roomId}")
    public void updateRoom(
            @PathVariable("roomId") Long roomId,
            @RequestParam int capacity) {
        roomService.updateRoom(roomId, capacity);
    }
}
