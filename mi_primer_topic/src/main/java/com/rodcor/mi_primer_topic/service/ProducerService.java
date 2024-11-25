package com.rodcor.mi_primer_topic.service;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class ProducerService {

    // 1 producer try//////////////////////////////////////////////////////
//    private static final String TOPIC = "test_topic";
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    public void sendMessage(String message) {
//        kafkaTemplate.send(TOPIC, message);
//    }
    // 2 producer try/////////////////////////////////////////////////////

    private static final String TOPIC = "test_topic";
    private KafkaProducer<String, String> producer;

    public ProducerService() {
        Properties settings = new Properties();
        settings.put("client.id", "basic-producer-v0.1.0");
        settings.put("bootstrap.servers", "pkc-12576z.us-west2.gcp.confluent.cloud:9092");
        settings.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        settings.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        settings.put("security.protocol", "SASL_SSL"); settings.put("sasl.mechanism", "PLAIN");
        settings.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\"N5QIBSGMYS2U6EP4\" password=\"9ED1NwuVhR6Eu/DqOCVeQDtvm/ssrNnw4eSWBOHp7boPBfrXYLUm+db2EAmixjzV\";");
//        settings.put("session.timeout.ms", "45000");
        settings.put("acks", "all");

        this.producer = new KafkaProducer<>(settings);

//        Añade un hook para cerrar el productor de manera ordenada cuando la aplicación se detiene.
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("### Stopping Basic Producer ###"); producer.close();
        }));
    }

    public void sendMessage(String message) {
        ProducerRecord<String, String> record = new ProducerRecord<>(TOPIC, message);
        producer.send(record); }


}
