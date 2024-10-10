package com.example.demo.config;

import com.example.demo.model.Customer;
import com.example.demo.model.Manager;
import com.example.demo.model.Receptionist;
import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Bean
    CommandLineRunner userCommandLineRunner(UserRepository userRepository) {
        return args -> {
            userRepository.save(
                    new Customer("am2mcu", passwordEncoder.encode("am2mcu"), "Armin", "Mazloumi", "armynm005@gmail.com")
            );
            userRepository.save(
                    new Manager("a", passwordEncoder.encode("a"), "a@gmail.com")
            );
            userRepository.save(
                    new Receptionist("b", passwordEncoder.encode("b"), "b@gmail.com")
            );
        };
    }
}
