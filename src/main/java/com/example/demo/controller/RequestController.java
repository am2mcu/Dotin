package com.example.demo.controller;

import com.example.demo.model.Request;
import com.example.demo.service.RequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("requests")
@Tag(name = "request", description = "List & Modify reservations")
public class RequestController {
    @Autowired
    private RequestService requestService;

    @Operation(
            summary = "Get requests",
            description = "Get all requests properties"
    )
    @GetMapping()
    public List<Request> getRequests() {
        return requestService.getRequests();
    }

    @Operation(
            summary = "Request room",
            description = "Request a new room"
    )
    @PostMapping("/{roomId}")
    public void requestRoom(@PathVariable("roomId") Long roomId) {
        requestService.requestRoom(roomId);
    }
}
