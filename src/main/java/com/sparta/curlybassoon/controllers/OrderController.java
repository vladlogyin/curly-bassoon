package com.sparta.curlybassoon.controllers;

import com.sparta.curlybassoon.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.sparta.curlybassoon.repositories.OrderRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository repo;

   @GetMapping("/orders")
    public String orders(Model model){
       Order[] order = repo.findAll().toArray(new Order[0]);
       model.addAttribute("orders", order);
       return "order";
   }

   @GetMapping("/order/{id}")
    public String orderById(@PathVariable int id, Model model){
       Order order = repo.findById(id).get();
       model.addAttribute("orders", order);
       return "order";
   }

   @GetMapping("/order/edit/{id}")
    public String editOrderById(@PathVariable int id, Model model){
       Order order = repo.findById(id).get();
       model.addAttribute("orderToEdit", order);
       return "order-form";
   }

   @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute ("orderToEdit") Order order){
       repo.save(order);
       return "success";
   }

   @GetMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable int id){
       repo.delete(repo.findById(id).get());
       return "order";
   }
}
