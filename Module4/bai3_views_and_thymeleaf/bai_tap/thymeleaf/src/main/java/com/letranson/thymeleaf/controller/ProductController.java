package com.letranson.thymeleaf.controller;

import com.letranson.thymeleaf.model.Product;
import com.letranson.thymeleaf.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = {""}, name = "productController")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping(value = "/edit/{id:[0-2]}")
    public String showEditPage(@PathVariable("id") int productId, ModelMap modelMap) {
        modelMap.addAttribute("product", productService.finById(productId));
        return "edit";
    }


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showProductList() {
        return new ModelAndView("list", "productList",
                productService.findAll());
    }

    @GetMapping(value = "/create")
    public String showCreatePage(Model model) {
        model.addAttribute("product", new Product());

        List<String> productList = new ArrayList<>();
        productList.add("Samsung");
        productList.add("iPhone");
        productList.add("Sony");
        model.addAttribute("productList", productList);

        return "create";
    }

    @PostMapping(value = "/create")
    public String createProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("successMsg", "Create product: "
                + product.getName() + " OK");
        productService.save(product);
        return "redirect:/list";
    }
}