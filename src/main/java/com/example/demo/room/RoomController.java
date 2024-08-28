package com.example.demo.room;

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

//    @GetMapping
//    public List<Room> getRooms() {
//        return roomService.getRooms();
//    }

    @GetMapping()
    public List<Room> getAvailableRooms() {
        return roomService.getAvailableRooms();
    }

    @PostMapping
    public void addRoom(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @DeleteMapping(path = "{roomId}")
    public void deleteStudent(@PathVariable("roomId") Long roomId) {
        roomService.deleteRoom(roomId);
    }

    @PutMapping(path = "{roomId}")
    public void updateRoom(
            @PathVariable("roomId") Long roomId,
            @RequestParam(required = false) String status) {
        roomService.updateRoom(roomId, status);
    }
}
