package com.example.demo.controller;

import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
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

    @GetMapping("/rooms")
    public List<Room> getRooms() {
        return roomService.getRooms();
    }

    @PostMapping("/rooms")
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @DeleteMapping("/rooms/{roomId}")
    public void deleteRoom(@PathVariable("roomId") Long roomId) {
        roomService.deleteRoom(roomId);
    }

    @PutMapping("/rooms/{roomId}")
    public void updateRoom(
            @PathVariable("roomId") Long roomId,
            @RequestParam int capacity) {
        roomService.updateRoom(roomId, capacity);
    }

    @GetMapping("/reserved_rooms")
    public List<Reservation> getReservedRooms() {
        return roomService.getReservedRooms();
    }

    @PostMapping("/reserve_room/{roomId}")
    public void reserveRoom(@PathVariable("roomId") Long roomId) {
        roomService.reserveRoom(roomId);
    }
}
