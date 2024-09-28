package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.repo.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }
}
