package com.example.demo.room;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RoomConfig {
    @Bean
    CommandLineRunner commandLineRunner(RoomRepository roomRepository) {
        return args -> {
            Room room1 = new Room(3);
            Room room2 = new Room(2);
            Room room3 = new Room(4);

            roomRepository.saveAll(List.of(room1, room2, room3));
        };
    }
}
