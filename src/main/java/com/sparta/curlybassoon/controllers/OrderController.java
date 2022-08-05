package com.sparta.curlybassoon.controllers;

import com.sparta.curlybassoon.entities.Order;
import com.sparta.curlybassoon.entities.Product;
import com.sparta.curlybassoon.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.sparta.curlybassoon.repositories.OrderRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("productList")
public class OrderController {

    @Autowired
    private OrderRepository repo;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/orders")
    public String orders(Model model) {
        Order[] order = repo.findAll().toArray(new Order[0]);
        model.addAttribute("orders", order);
        return "order";
    }

    @GetMapping("/order/{id}")
    public String orderById(@PathVariable int id, Model model) {
        Order order = repo.findById(id).get();
        model.addAttribute("orders", order);
        return "order";
    }

    // TODO new order required
    @ModelAttribute("productList")
    public List<Product> productList(){
        return new ArrayList<Product>();
    }

    @GetMapping("/order/new")
    public String createNewOrder() {
        return "order-new";
    }

    @GetMapping("/order/add/{id}") // change to orderList/add/{id}?
    public String addProductToOrder(@PathVariable int id,
                                  Model model,
                                  @ModelAttribute("productList") List<Product> pList){
        Product product = productRepository.findById(id).get(); // TODO check for empty optional
        pList.add(product);
        model.addAttribute("list", Arrays.toString(pList.toArray()));
        return "order-new";
    }

//    @GetMapping("/order/remove/{id}")
//    public String removeProductFromOrder(){
//        return ""; // TODO extra feature
//    }

    @PostMapping("/order/process/") // change to orderList/process?
    public String processNewOrder(@ModelAttribute("castList") List<Product> productList,
                                  Model model){
        // TODO process product list into an order(s) to northwind database
        return "redirect:/orders";
    }

    @GetMapping("/order/edit/{id}")
    public String editOrderById(@PathVariable int id, Model model) {
        Order order = repo.findById(id).get();
        model.addAttribute("orderToEdit", order);
        return "order-form";
    }

    @PostMapping("/updateOrder")
    public String updateOrder(@ModelAttribute("orderToEdit") Order order) {
        repo.save(order);
        return "success";
    }

    @GetMapping("/order/delete/{id}")
    public String deleteOrder(@PathVariable int id) {
        repo.delete(repo.findById(id).get());
        return "redirect:/orders";
    }
}
