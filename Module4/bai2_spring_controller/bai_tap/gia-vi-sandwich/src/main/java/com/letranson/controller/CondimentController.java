package com.letranson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CondimentController {
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @PostMapping("/save")
    public ModelAndView condiments(@RequestParam String[] condiments) {
        ModelAndView modelAndView = new ModelAndView("index");
        if (condiments.length == 0)
            modelAndView.addObject("messenger", "Ban can chon 1 gia vi");
        List<String> listCondiment= new ArrayList<>();
        for (String sp : condiments) {
            listCondiment.add(sp);
        }
        modelAndView.addObject("listCondiment", listCondiment);
        return modelAndView;
    }

}
