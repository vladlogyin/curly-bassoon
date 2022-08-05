package com.sparta.curlybassoon.controllers;

import com.sparta.curlybassoon.entities.Customer;
import com.sparta.curlybassoon.entities.Employee;
import com.sparta.curlybassoon.entities.Product;
import com.sparta.curlybassoon.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository repo;

    //New product
    @GetMapping("/product/new")
    public String newProduct() {
        return "product-new";
    }

    @PostMapping("/product/add")
    public String addProduct(@ModelAttribute("productToAdd") Product product, Model model){
        System.out.println(product);
        repo.save(product);
        return "success";
    }

    //View all products
    @GetMapping("/products")
    public String getAllProducts(Model model) {
        Product[] products = repo.findAll().toArray(new Product[0]);
        model.addAttribute("products", products);
        return "product";
    }

    //View specific product
    @GetMapping("/product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        Product product = repo.findById(id).get();
        model.addAttribute("products", product);
        return "product";
    }

    //Edit specific product
    @GetMapping("/product/edit/{id}")
    public String editProductById(@PathVariable int id, Model model) {
        Product product = repo.findById(id).get();
        model.addAttribute("productToEdit", product);
        return "product-form";
    }

    //Update product
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("productToEdit") Product product) {
        repo.save(product);
        return "redirect:/products";
    }

    //Delete specific product
    @GetMapping("/product/delete/{id}")
    public String deleteProductById(@PathVariable int id) {
        if(repo.existsById(id)){
            repo.delete(repo.findById(id).get());
            return "redirect:/products";
        }
        return "redirect:/products";
    }
/*
    @GetMapping("/basket/add/{id}")
    public String addBasketMember(@PathVariable int id, @ModelAttribute("basketList") List<Product> basketList) {
        Product product = repo.findById(id).get();
        basketList.add(product);
        return "basket";
    }*/

    @ModelAttribute("basketList")
    public List<Product> basketList() {
        return new ArrayList<Product>();
    }

}