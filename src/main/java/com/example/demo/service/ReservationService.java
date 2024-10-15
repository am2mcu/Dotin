package com.example.demo.service;

import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repo.ReservationRepository;
import com.example.demo.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(ReservationService.class);
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository, UserRepository userRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    public List<Reservation> getReservations() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getAuthorities().stream().anyMatch(
                authority -> authority.getAuthority().equals("ROLE_MANAGER") || authority.getAuthority().equals("ROLE_RECEPTIONIST")
        )) {
            logger.info("All reserved rooms selected from DB");
            return reservationRepository.findAll();
        } else if (authentication.getAuthorities().stream().anyMatch(
                authority -> authority.getAuthority().equals("ROLE_CUSTOMER")
        )) {
            User user = userRepository.findByUsername(authentication.getName())
                    .orElseThrow(() -> {
                        throw new UsernameNotFoundException("Username not found");
                    });

            logger.info("User reserved rooms selected from DB");
            return reservationRepository.getByUser(user);
        }

        return new ArrayList<>();
    }
}
