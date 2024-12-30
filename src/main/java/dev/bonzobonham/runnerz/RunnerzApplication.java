package dev.bonzobonham.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerzApplication {

	private final static Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		
		log.info("Hello Spring Boot!");
	}

	//Bean: Instance of a class with specific metadata, handled by Spring

}
