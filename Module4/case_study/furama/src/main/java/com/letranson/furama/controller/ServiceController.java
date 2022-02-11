package com.letranson.furama.controller;

import com.letranson.furama.bean.RentType;
import com.letranson.furama.bean.Service;
import com.letranson.furama.bean.ServiceType;
import com.letranson.furama.service.RentTypeService;
import com.letranson.furama.service.ServiceService;
import com.letranson.furama.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.print.attribute.standard.Media;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
@RequestMapping(value = "/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private RentTypeService rentTypeService;

    @Autowired
    private ServiceTypeService serviceTypeService;

    @ModelAttribute("rentType")
    public Iterable<RentType> rentTypes() {
        return rentTypeService.findAll();
    }

    @ModelAttribute("serviceType")
    public Iterable<ServiceType> serviceTypes() {
        return serviceTypeService.findAll();
    }

    @ModelAttribute
    public Model getUserName(@CookieValue(value = "employeeUser", defaultValue = "") String employeeUser,Model model){
        Cookie cookie = new Cookie("setUser", employeeUser);
        model.addAttribute("cookieValue", cookie);
        return model;
    }

    @GetMapping(value = "/showAll")
    public ModelAndView showAll(@PageableDefault(value = 9) Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("service/showAllService");
        if (services.getContent().size() == 0) {
            modelAndView.addObject("msg", "chua co dich vu nao.");
            return modelAndView;
        }
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping(value = "/pageService")
    public ModelAndView getPageService(@PageableDefault(value = 9) Pageable pageable) {
        Page<Service> services = serviceService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("service/listService");
        if (services.getContent().size() == 0) {
            modelAndView.addObject("msg", "chua co dich vu nao.");
            return modelAndView;
        }
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping(value = "/search/{searchValue}")
    public ModelAndView showListSearch(@PageableDefault(value = 9) Pageable pageable, @PathVariable("searchValue") String name) {
        Page<Service> services = serviceService.findByName(pageable, "%" + name + "%");
        ModelAndView modelAndView = new ModelAndView("service/resultSearchService");
        if (services.getContent().size() == 0) {
            modelAndView.addObject("msg", "Not found.");
            return modelAndView;
        }
        modelAndView.addObject("services", services);
        return modelAndView;
    }

    @GetMapping(value = "/showDetail/{id}")
    public String showDetail(@PathVariable String id, Model model) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        return "service/showDetailService";
    }

    @GetMapping(value = "/create")
    public String showPageCreateService(Model model) {
        model.addAttribute("service", new Service());
        return "service/createService";
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String save(@Validated @ModelAttribute Service service,
                       BindingResult bindingResult, @RequestParam(value = "img") MultipartFile img,
                       RedirectAttributes redirectAttributes,
                       Model model) {
        if (bindingResult.hasFieldErrors() && img.isEmpty()) {
            model.addAttribute("msg","Khong duoc de trong.");
            return "service/createService";
        } else {
            Path path = Paths.get("upload/");
            try {
                InputStream inputStream = img.getInputStream();
                Files.copy(inputStream, path.resolve(img.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
                service.setLinkImg(img.getOriginalFilename().toLowerCase());
            } catch (IOException e) {
                e.printStackTrace();
            }
            redirectAttributes.addFlashAttribute("msg", "Create service : " + service.getServiceName() + " success.");
            String idService = "DV-" + ((int) (Math.random() * 10000));
            service.setServiceId(idService);
            serviceService.save(service);
            return "redirect:/service/showAll";
        }
    }

    @GetMapping(value = "/update/{id}")
    public String showPageUpdate(@PathVariable String id, Model model) {
        Service service = serviceService.findById(id);
        model.addAttribute("service", service);
        return "service/updateService";
    }

    @PostMapping(value = "/update")
    public String update(@Validated @ModelAttribute Service service, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()){
            return "/service/updateService";
        }else {
            redirectAttributes.addFlashAttribute("msg", "Update service : " + service.getServiceName() + " success.");
            serviceService.save(service);
            return "redirect:/service/showAll";
        }
    }

    @GetMapping(value = "/delete/{id}")
    public String deleteCustomer(@PathVariable String id, RedirectAttributes redirectAttributes) {
        Service service = serviceService.findById(id);
        redirectAttributes.addFlashAttribute("msg", "Delete customer: " + service.getServiceName() + "success.");
        serviceService.delete(service);
        return "redirect:/service/showAll";
    }
}