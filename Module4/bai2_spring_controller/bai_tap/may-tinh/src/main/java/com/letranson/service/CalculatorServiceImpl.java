package com.letranson.service;


import com.letranson.repository.CalculatorRepository;
import com.letranson.repository.CalculatorRepositoryImpl;

public class CalculatorServiceImpl implements CalculatorService{
    CalculatorRepository calculatorRepository = new CalculatorRepositoryImpl();
    @Override
    public double calculator(Integer number1, Integer number2, String operator) {
        return calculatorRepository.calculator(number1,number2,operator);
    }
}
