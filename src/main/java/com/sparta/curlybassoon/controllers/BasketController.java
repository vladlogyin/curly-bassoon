package com.sparta.curlybassoon.controllers;

import com.sparta.curlybassoon.entities.Product;
import com.sparta.curlybassoon.repositories.CustomerRepository;
import com.sparta.curlybassoon.repositories.ProductRepository;
import com.sparta.curlybassoon.services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BasketController {

    @Autowired
    private ProductRepository repo;

    @Autowired
    private BasketService basket;

    @GetMapping("/basket")
    public ModelAndView getBasket()
    {
        ModelAndView modelAndView = new ModelAndView("/basket");
        modelAndView.addObject("products", basket.getProducts());
        modelAndView.addObject("total", basket.getTotal().toString());
        return modelAndView;
    }

    @GetMapping("/basket/add/{id}")
    public String addBasketMember(@PathVariable int id) {

        Product product = repo.findById(id).get();
        basket.addProduct(product);
        return "redirect:/products";
    }
}
