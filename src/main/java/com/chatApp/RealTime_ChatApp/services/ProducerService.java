// package com.chatApp.RealTime_ChatApp.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.kafka.core.KafkaTemplate;
// import org.springframework.stereotype.Service;

// @Service
// public class ProducerService {
    
// 	@Autowired
// 	private KafkaTemplate<String, String> kafkaTemplate;
	
// 	String kafkaTopic = "java_in_use_topic";
	
// 	public void send(String message) {
// 	    kafkaTemplate.send(kafkaTopic, message);
// 	}
// }