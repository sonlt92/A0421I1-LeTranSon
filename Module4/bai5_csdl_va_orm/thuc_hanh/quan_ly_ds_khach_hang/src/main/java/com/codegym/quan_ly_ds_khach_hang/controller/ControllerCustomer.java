package com.codegym.quan_ly_ds_khach_hang.controller;


import com.codegym.quan_ly_ds_khach_hang.model.bean.Customer;
import com.codegym.quan_ly_ds_khach_hang.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
public class ControllerCustomer {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "")
    public String home() {
        return "index";
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ModelAndView showAll() {
        return new ModelAndView("show", "customerList", customerService.findAll());
    }

    @GetMapping(value = "/create")
    public String showCreatePage(Model model) {
        model.addAttribute("customer", new Customer());

        return "create";
    }

    @PostMapping(value = "/create")
    public String create(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msg", "Create customer :" + customer.getName() +
                " success.");
        customerService.save(customer);
        return "redirect:/show";
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditPage(@PathVariable int id) {
        Customer customer = customerService.finById(id);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public String edit(@ModelAttribute Customer customer, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg", "Edit customer :" + customer.getName() +
                " success.");
        customerService.edit(customer);
        return "redirect:/show";
    }

    @GetMapping(value = "/delete/{id}/{name}")
    public String delete(@PathVariable int id,@PathVariable String name, RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("msg", "Delete customer :" + name +
                " success.");
        customerService.delete(id);
        return "redirect:/show";
    }

    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam String searchValue){
        return new ModelAndView("show", "customerList", customerService.search(searchValue));
    }
}
