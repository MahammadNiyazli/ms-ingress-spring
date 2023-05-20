package com.company.DI.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public Logger logger(){
        return LoggerFactory.getLogger("ms-ingress-spring");
    }

}
