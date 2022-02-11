package com.letranson.furama.controller;

import com.letranson.furama.bean.Employee;
import com.letranson.furama.bean.User;
import com.letranson.furama.service.EmployeeService;
import com.letranson.furama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;


@Controller
public class LoginLogoutController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/")
    public String showIndex(@CookieValue(value = "employeeUser", defaultValue = "") String employeeUser, Model model) {
        Cookie cookie = new Cookie("setUser", employeeUser);
        model.addAttribute("cookieValue", cookie);
        return "index";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String showHomePage(@CookieValue(value = "employeeUser", defaultValue = "") String employeeUser, Model model) {
        Cookie cookie = new Cookie("setUser", employeeUser);
        model.addAttribute("cookieValue", cookie);
        return "index";
    }

    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSuccess(RedirectAttributes attributes, Principal principal,
                               Model model,
                               @CookieValue(value = "employeeUser", defaultValue = "") String employeeUser,
                               HttpServletResponse response) {
        String userName = principal.getName();
        User user = userService.findById(userName);
        Employee employee = employeeService.findByUser(user);
        attributes.addFlashAttribute("employee", employee);
        model.addAttribute("employee", employee);
        Cookie cookie = new Cookie("employeeUser", employee.getName());
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);
        model.addAttribute("cookieValue", cookie);
        return "index";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String showErrorPage(@CookieValue(value = "employeeUser", defaultValue = "") String employeeUser, Model model) {
        Cookie cookie = new Cookie("setUser", employeeUser);
        model.addAttribute("cookieValue", cookie);
        return "403Error";
    }

    @RequestMapping("/logoutSuccess")
    public String logout() {
        return "login";
    }
}

