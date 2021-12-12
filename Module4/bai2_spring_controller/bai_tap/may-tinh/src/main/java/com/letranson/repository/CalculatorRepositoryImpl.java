package com.letranson.repository;

public class CalculatorRepositoryImpl implements CalculatorRepository {
    @Override
    public double calculator(Integer number1, Integer number2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                result = number1 / number2;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        return result;
    }
}
