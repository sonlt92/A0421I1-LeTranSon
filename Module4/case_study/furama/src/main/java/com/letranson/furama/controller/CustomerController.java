package com.letranson.furama.controller;

import com.letranson.furama.bean.Customer;
import com.letranson.furama.bean.CustomerType;
import com.letranson.furama.service.CustomerService;
import com.letranson.furama.service.TypeOfCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private TypeOfCustomerService typeOfCustomerService;

    @ModelAttribute
    public Model getUserName(@CookieValue(value = "employeeUser", defaultValue = "") String employeeUser,Model model){
        Cookie cookie = new Cookie("setUser", employeeUser);
        model.addAttribute("cookieValue", cookie);
        return model;
    }

    @ModelAttribute("typeCus")
    public Iterable<CustomerType> typeCus() {
        return typeOfCustomerService.findAll();
    }

    @GetMapping(value = "/show")
    public ModelAndView displayPageShow(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = customerService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/showCustomer");
        modelAndView.addObject("customers", customers);
        if (customers == null) {
            modelAndView.addObject("msg", "Chưa có khách hàng.");
        }
        return modelAndView;
    }

    @GetMapping(value = "/tableCustomer")
    public ModelAndView getTableCustomer(@PageableDefault(value = 5) Pageable pageable) {
        Page<Customer> customers = customerService.showAll(pageable);
        ModelAndView modelAndView = new ModelAndView("customer/tableCustomer");
        modelAndView.addObject("customers", customers);
        if (customers == null) {
            modelAndView.addObject("msg", "Chưa có khách hàng.");
        }
        return modelAndView;
    }


    @GetMapping(value = "/search/{searchValue}")
    public ModelAndView showListSearch(@PageableDefault(value = 5) Pageable pageable, @PathVariable("searchValue") String name) {
        Page<Customer> customers = customerService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("customer/resultSearchCustomer");
        modelAndView.addObject("customers", customers);
        if (customers.getContent().size() == 0) {
            modelAndView.addObject("msg", "Not found.");
        }
        return modelAndView;
    }

    @GetMapping(value = "/create")
    public String displayPageCreate(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/createCustomer";
    }

    @PostMapping(value = "/create")
    public String saveCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "customer/createCustomer";
        } else {
            redirectAttributes.addFlashAttribute("msg", "Create customer: " + customer.getCustomerName() + " success.");
            String idCus = "KH-" + ((int) (Math.random() * 10000));
            customer.setCustomerId(idCus);
            customerService.save(customer);
            return "redirect:/customer/show";
        }
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showPageUpdate(@PathVariable String id) {
        Customer customer = customerService.findById(id);
        return new ModelAndView("customer/updateCustomer", "customer", customer);
    }

    @PostMapping(value = "/edit")
    public String updateCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()){
            return "/customer/updateCustomer";
        }else {
            redirectAttributes.addFlashAttribute("msg", "Update customer: " + customer.getCustomerName() + " success.");
            customerService.save(customer);
            return "redirect:/customer/show";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        Customer customer = customerService.findById(id);
        redirectAttributes.addFlashAttribute("msg", "Delete customer: " + customer.getCustomerName() + "success.");
        customerService.delete(customer);
        return "redirect:/customer/show";
    }
}

