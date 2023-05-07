package com.company.DI;

import com.company.DI.prototype.Customer;
import com.company.DI.prototype.CustomerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DIApplication {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(CustomerConfiguration.class);

		Customer customer = context.getBean(Customer.class);
		System.err.println(customer);

		Customer customer2 = context.getBean(Customer.class);
		System.err.println(customer2);

		//SpringApplication.run(DIApplication.class, args);
	}

}
