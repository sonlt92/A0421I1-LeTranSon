package com.letranson.service;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorService {
    double calculator(Integer number1, Integer number2, String operator) ;
}
