package com.company.DI;

import com.company.DI.dto.User;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DIApplication implements CommandLineRunner {

	public DIApplication(Logger logger) {
		this.logger = logger;
	}

	public static void main(String[] args) {
		SpringApplication.run(DIApplication.class, args);
	}

	private final Logger logger;

	@Override
	public void run(String... args) throws Exception {
		User user = new User(1L,"Mahammad","Niyazli",23);
		logger.info(user.toString());
		logger.error(user.toString());
		logger.warn(user.toString());
	}
}
