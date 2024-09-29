package com.example.demo.config;

import com.example.demo.model.Customer;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(
                    new Customer("am2mcu", "am2mcu", "Armin", "Mazloumi", "armynm005@gmail.com")
            );
        };
    }
}
