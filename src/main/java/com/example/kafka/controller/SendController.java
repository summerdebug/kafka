package com.example.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/send")
public class SendController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/message")
    public ResponseEntity<String> message() {
        kafkaTemplate.send("quickstart-events", "Message from spring boot");
        return ResponseEntity.ok("Message");
    }
}
