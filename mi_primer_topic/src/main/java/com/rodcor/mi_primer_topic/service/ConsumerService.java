package com.rodcor.mi_primer_topic.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    // KafkaListener annotation to listen to messages from the specified Kafka topic
    @KafkaListener(topics = "test_topic", groupId = "my-group")
    public void consume(String message) {
        // Print the received message to the console
        System.out.println("Mensaje recibido: " + message);
    }
}
