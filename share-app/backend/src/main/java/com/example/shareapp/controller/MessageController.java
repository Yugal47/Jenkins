package com.example.shareapp.controller;

import com.example.shareapp.model.ClickLog;
import com.example.shareapp.repository.ClickLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000") // allow the React dev server to call this API
public class MessageController {

    @Autowired
    private ClickLogRepository clickLogRepository;

    // Called when the button is clicked on the frontend
    @GetMapping("/message")
    public Map<String, Object> getMessage() {
        String text = "Hello from Spring Boot! Button click received.";

        // Save a record of this click to the database
        ClickLog log = new ClickLog(text, LocalDateTime.now());
        clickLogRepository.save(log);

        return Map.of(
                "message", text,
                "clickCount", clickLogRepository.count()
        );
    }

    // Optional: view click history
    @GetMapping("/history")
    public List<ClickLog> getHistory() {
        return clickLogRepository.findAll();
    }
}
