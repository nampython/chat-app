package com.chatApp.RealTime_ChatApp.controllers;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;

import com.chatApp.RealTime_ChatApp.constants.KafkaConstants;
import com.chatApp.RealTime_ChatApp.models.Message;
import com.chatApp.RealTime_ChatApp.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    
    @Autowired
    private ProducerService producerService;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody Message message){
        message.setTimestamp(LocalDateTime.now().toString());
        producerService.send(message);
    }

}
