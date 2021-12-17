package com.letranson.email.controller;


import com.letranson.email.model.Email;
import com.letranson.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("abc")
@Controller
public class EmailController {
    @GetMapping("")
    public ModelAndView modelAndView(){
        List<String> languages=new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Chinese");
        languages.add("Spain");
        List<Integer> pageList=new ArrayList<>();
        pageList.add(5);
        pageList.add(10);
        pageList.add(15);
        pageList.add(25);
        pageList.add(50);
        pageList.add(100);
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("languages",languages);
        modelAndView.addObject("pageList",pageList);
        modelAndView.addObject("email",new Email());
        return modelAndView;
    }
    @Autowired
    EmailService emailService;


    @GetMapping("/showEmail")
    public ModelAndView showEmail(){
        ModelAndView modelAndView=new ModelAndView("reult");
        List<Email> emailList= emailService.showAll();
        modelAndView.addObject("listEmail",emailList);
        return modelAndView;
    }

    @PostMapping("/send")
    public String sendEmail(@ModelAttribute Email email, RedirectAttributes redirectAttributes){
        if(email==null)
            redirectAttributes.addFlashAttribute("error","Có lỗi");
        else
            emailService.addEmail(email);
        return "redirect:/showEmail";
    }
}
