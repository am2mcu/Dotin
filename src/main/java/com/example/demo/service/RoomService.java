package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repo.ReservationRepository;
import com.example.demo.repo.RoomRepository;
import com.example.demo.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);
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
        logger.info("Rooms selected from DB");
        return roomRepository.findAll();
    }

    public void addRoom(Room room) {
        Optional<Room> roomOptional = roomRepository.findRoomById(room.getRoomId());
        if (roomOptional.isPresent()) {
            logger.error("Room number exists!");
            throw new IllegalStateException("Room number exists!");
        }
        logger.info("Room added");
        roomRepository.save(room);
    }

    public void deleteRoom(Long roomId) {
        if (!roomRepository.existsById(roomId)) {
            logger.error("Room id " + roomId + " not found!");
            throw new IllegalStateException("Room id " + roomId + " not found!");
        }
        logger.info("Room Deleted");
        roomRepository.deleteById(roomId);
    }

    @Transactional
    public void updateRoom(Long roomId, int capacity) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> {
            logger.error("Room does not exists!");
            throw new IllegalStateException("Room does not exists!");
        });
        logger.info("Room updated");
        room.setCapacity(capacity);
    }

    public List<Reservation> getReservedRooms() {
        logger.info("Reserved rooms selected from DB");
        return reservationRepository.findAll();
    }
    public void reserveRoom(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> {
            logger.error("Room does not exists!");
            throw new IllegalStateException("Room does not exists!");
        });
        User user = userRepository.findById(1L).orElseThrow(() -> {
            logger.error("User does not exists!");
            throw new IllegalStateException("User does not exists!");
        });

        logger.info("Room reserved");
        reservationRepository.save(new Reservation(room, user));
    }
}
