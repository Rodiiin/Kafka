package com.rodcor.mi_primer_topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MiPrimerTopicApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiPrimerTopicApplication.class, args);
	}

}
