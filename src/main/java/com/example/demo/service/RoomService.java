package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repo.ReservationRepository;
import com.example.demo.repo.RoomRepository;
import com.example.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getRooms() {
        return roomRepository.findAll();
    }

    public void addRoom(Room room) {
        Optional<Room> roomOptional = roomRepository.findRoomById(room.getRoomId());
        if (roomOptional.isPresent()) {
            throw new IllegalStateException("Room number exists!");
        }
        roomRepository.save(room);
    }

    public void deleteRoom(Long roomId) {
        if (!roomRepository.existsById(roomId))
            throw new IllegalStateException("Room id " + roomId + " not found!");
        roomRepository.deleteById(roomId);
    }

    @Transactional
    public void updateRoom(Long roomId, int capacity) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new IllegalStateException("Room does not exists!"));
        room.setCapacity(capacity);
    }

    public List<Reservation> getReservedRooms() {
        return reservationRepository.findAll();
    }
    public void reserveRoom(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> new IllegalStateException("Room does not exists!"));
        User user = userRepository.findById(1L).orElseThrow(() -> new IllegalStateException("User does not exists!"));

        reservationRepository.save(new Reservation(room, user));
    }
}
