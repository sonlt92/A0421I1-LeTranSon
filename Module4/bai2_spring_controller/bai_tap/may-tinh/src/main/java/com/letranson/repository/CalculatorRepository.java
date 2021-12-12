package com.letranson.repository;

import org.springframework.stereotype.Service;

@Service
public interface CalculatorRepository {
    double calculator(Integer number1, Integer number2, String operator);
}
