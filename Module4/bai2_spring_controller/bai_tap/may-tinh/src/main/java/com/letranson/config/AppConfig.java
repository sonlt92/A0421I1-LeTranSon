package com.letranson.config;

import com.letranson.service.CalculatorService;
import com.letranson.service.CalculatorServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorServiceImpl();
    }

}
