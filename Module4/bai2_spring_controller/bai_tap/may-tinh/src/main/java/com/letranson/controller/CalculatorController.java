package com.letranson.controller;

import com.letranson.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/calculator")
    public ModelAndView plus(@RequestParam Integer number1, @RequestParam Integer number2, @RequestParam String operator) {
        ModelAndView modelAndView = new ModelAndView("index");
        double result = 0;
        try {
            result = calculatorService.calculator(number1, number2, operator);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String msg = number2 == 0 ? "Can't divide a zero" : null;
        modelAndView.addObject("msg", msg);
        modelAndView.addObject("kq", result);
        return modelAndView;
    }
}
