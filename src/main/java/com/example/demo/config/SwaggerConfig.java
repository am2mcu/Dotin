package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Configuration
@EnableWebMvc
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Under development...");

        Contact myContact = new Contact();
        myContact.setName("am2mcu");
        myContact.setEmail("armynm005@gmail.com");

        Info info = new Info()
                .title("Room Reservation API")
                .version("1.0")
                .description("API for managing room reservation")
                .contact(myContact);

        return new OpenAPI().info(info).servers(List.of(server));
    }
}
