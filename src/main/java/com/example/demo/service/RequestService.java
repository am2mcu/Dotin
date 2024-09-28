package com.example.demo.service;

import com.example.demo.model.Request;
import com.example.demo.model.Room;
import com.example.demo.model.User;
import com.example.demo.repo.RequestRepository;
import com.example.demo.repo.ReservationRepository;
import com.example.demo.repo.RoomRepository;
import com.example.demo.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {
    private static final Logger logger = LoggerFactory.getLogger(RequestService.class);
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Request> getRequests() {
        logger.info("Requests selected from DB");
        return requestRepository.findAll();
    }
    public void requestRoom(Long roomId) {
        Room room = roomRepository.findById(roomId).orElseThrow(() -> {
            logger.error("Room does not exists!");
            throw new IllegalStateException("Room does not exists!");
        });
        User user = userRepository.findById(1L).orElseThrow(() -> {
            logger.error("User does not exists!");
            throw new IllegalStateException("User does not exists!");
        });

        logger.info("Room requested");
        requestRepository.save(new Request(room, user));
    }
}
