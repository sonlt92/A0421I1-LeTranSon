package com.codegym.gio_hang.controller;

import com.codegym.gio_hang.bean.Cart;
import com.codegym.gio_hang.bean.Product;
import com.codegym.gio_hang.service.ProductBuyService;
import com.codegym.gio_hang.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.Map;


@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductBuyService productBuyService;

    @ModelAttribute("cart")
    public HashMap<Long, Cart> setProduct() {
        return new HashMap<Long, Cart>();
    }

    @GetMapping("/")
    public String showPageIndex(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/detail/{id}")
    public String showDetailProduct(@PathVariable("id") Integer id,
                                    @SessionAttribute("cart") HashMap<Integer, Cart> cartHashMap,
                                    Model model){
        model.addAttribute("product",productService.findById(id));
        model.addAttribute("cartNum",cartHashMap.size());
        return "detail";
    }


    @GetMapping("/add/{id}")
    public String addSession(@PathVariable("id") Integer id,
                             @ModelAttribute("cart") HashMap<Integer, Cart> cartHashMap,
                             Model model) {
        if (cartHashMap == null){
            cartHashMap = new HashMap<>();
        }
        Product product = productService.findById(id);
        if (product!=null){
            Cart cart;
            if (cartHashMap.containsKey(id)){
                cart = cartHashMap.get(id);
                cart.setProduct(product);
                cart.setQuantity(cart.getQuantity()+1);
            }else {
                cart = new Cart();
                cart.setProduct(product);
                cart.setQuantity(1);
            }
            cartHashMap.put(id, cart);
        }

        model.addAttribute("products", productService.findAll());
        model.addAttribute("cartNum",cartHashMap.size());
        model.addAttribute("cart", cartHashMap);
        return "index";
    }

    @GetMapping(value = "/cart")
    public String showCart(@SessionAttribute("cart") HashMap<Integer, Cart> cartHashMap,
                           Model model){
        model.addAttribute("carts",cartHashMap);
        model.addAttribute("total",totalPrice(cartHashMap));
        return "cart";
    }



    public Integer totalPrice(HashMap<Integer, Cart> cartHashMap){
        int total = 0;
        for (Map.Entry<Integer, Cart> list : cartHashMap.entrySet()){
            total += list.getValue().getProduct().getPrice()* list.getValue().getQuantity();
        }
        return total;
    }
}