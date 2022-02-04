package com.chatApp.RealTime_ChatApp.services;

import com.chatApp.RealTime_ChatApp.constants.KafkaConstants;
import com.chatApp.RealTime_ChatApp.models.Message;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = KafkaConstants.KAFKA_TOPIC, groupId = "CHATAPP")
    public void listener(Message message){
        System.out.println("Received Message in group foo: " + message);
    }

}
