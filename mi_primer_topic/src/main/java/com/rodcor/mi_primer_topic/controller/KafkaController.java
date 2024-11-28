package com.rodcor.mi_primer_topic.controller;

import com.rodcor.mi_primer_topic.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    // Automatically inject the ProducerService bean
    @Autowired
    private ProducerService producer;

    // Endpoint to publish messages to Kafka topic
    @PostMapping("/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        // Use the producer service to send the message
        producer.sendMessage(message);
    }
}

