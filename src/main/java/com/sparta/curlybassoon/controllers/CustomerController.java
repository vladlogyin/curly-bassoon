package com.sparta.curlybassoon.controllers;

import com.sparta.curlybassoon.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import com.sparta.curlybassoon.repositories.CustomerRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository repo;

    /* View customers */
    @GetMapping("/customers")
    public String viewAllCustomers(Model model){
        var customers = repo.findAll();
        model.addAttribute("customers", customers);
        return "customer";
    }

    /* New Customer */
    @GetMapping("/customer/new")
    public String addCustomerForm(){
        return "customer-new";
    }

    @PostMapping("/customer/add")
    public String addCustomer(@ModelAttribute("customerObject") Customer newCustomer, Model model){
        repo.save(newCustomer);
        return "redirect:/customers";
    }

    /* Edit Customer */
    @GetMapping("/customer/edit/{id}")
    public String editCustomerForm(@PathVariable String id, Model model){
        Customer customer = repo.findById(id).get();
        model.addAttribute("customerObject", customer);
        return "customer-form";
    }

    @PostMapping("/customer/edit")
    public String editCustomer(@ModelAttribute("customerObject") Customer customer, Model model){
        repo.save(customer);
        return "redirect:/customers";
    }

    /* Delete Customer */
    @GetMapping("/customer/delete/{id}")
    public String deleteCustomerForm(@PathVariable String id, Model model){
        if(repo.existsById(id)){
            repo.delete(repo.findById(id).get());
            return "redirect:/customers"; // TODO successful
        }
        return "redirect:/customers"; // TODO failure redirect
    }
}
