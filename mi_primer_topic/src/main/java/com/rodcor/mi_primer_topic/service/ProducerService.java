package com.rodcor.mi_primer_topic.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ProducerService {

    private static final String TOPIC = "test_topic";
    private KafkaProducer<String, String> producer;

    public ProducerService() {
        Properties settings = new Properties();
        // Client ID for the producer
        settings.put("client.id", "basic-producer-v0.1.0");
        // Address of the Kafka broker
        settings.put("bootstrap.servers", "pkc-12576z.us-west2.gcp.confluent.cloud:9092");
        // Serializer for the key
        settings.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // Serializer for the value
        settings.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        // Security protocol and mechanism
        settings.put("security.protocol", "SASL_SSL");
        settings.put("sasl.mechanism", "PLAIN");
        settings.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"N5QIBSGMYS2U6EP4\" password=\"9ED1NwuVhR6Eu/DqOCVeQDtvm/ssrNnw4eSWBOHp7boPBfrXYLUm+db2EAmixjzV\";");
        // Acknowledgment settings
        settings.put("acks", "all");

        this.producer = new KafkaProducer<>(settings);

//        // Adds a shutdown hook to close the producer gracefully when the application stops.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("### Stopping Basic Producer ###"); producer.close();
        }));
    }

    // Method to send a message to the Kafka topic
    public void sendMessage(String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, message);
        producer.send(record); }


}
