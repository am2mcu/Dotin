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
public class ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(RoomService.class);
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private UserRepository userRepository;

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
