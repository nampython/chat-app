package com.chatApp.RealTime_ChatApp.services;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutionException;



import com.chatApp.RealTime_ChatApp.constants.KafkaConstants;
import com.chatApp.RealTime_ChatApp.models.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class ProducerService {

    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;

    public void send(Message message) {

        ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message);
        message.setTimestamp(LocalDateTime.now().toString());
        future.addCallback(new ListenableFutureCallback<SendResult<String, Message>>() {

            @Override
            public void onSuccess(SendResult<String, Message> result) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + message + "] due to : " + ex.getMessage());
            }
            
        });

        // try {
        //     kafkaTemplate.send(KafkaConstants.KAFKA_TOPIC, message).get();
        // } catch (InterruptedException | ExecutionException e) {
        //     throw new RuntimeException(e);
        // }
    }
}
