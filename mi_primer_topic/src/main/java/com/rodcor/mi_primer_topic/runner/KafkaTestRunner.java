//package com.rodcor.mi_primer_topic.runner;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class KafkaTestRunner implements CommandLineRunner {
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//    @Override public void run(String... args) throws Exception {
//        try {
//            kafkaTemplate.send("mi-tema", "Test message from Spring Boot");
//            System.out.println("Test message sent successfully!");
//        } catch (Exception e)
//            { e.printStackTrace();
//            }
//    }
//}
