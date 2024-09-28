package com.example.demo.config;

import com.example.demo.model.Room;
import com.example.demo.repo.RoomRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoomConfig {
    @Bean
    CommandLineRunner commandLineRunner(RoomRepository roomRepository) {
        return args -> {
            Room room1 = new Room(3, "Available");
            Room room2 = new Room(2, "Available");
            Room room3 = new Room(4, "Available");

            roomRepository.saveAll(List.of(room1, room2, room3));
        };
    }
}
