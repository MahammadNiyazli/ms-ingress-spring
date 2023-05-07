package com.company.DI.prototype;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomerConfiguration {

    @Bean
    @Scope("prototype")
    public Customer customer(){
        return new Customer();
    }

}
