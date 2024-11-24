package com.rodcor.mi_primer_topic.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

    @KafkaListener(topics = "test_topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Mensaje recibido: " + message);
    }
}
