package com.sparta.curlybassoon.controllers;

import com.sparta.curlybassoon.entities.Employee;
import com.sparta.curlybassoon.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee") // this will return all customers
    public String employee(Model model) {
        Employee[] employees = employeeRepository.findAll().toArray(new Employee[0]);
        model.addAttribute("actors", employees);
        return "employee";
    }

    @GetMapping("/employee/{id}") // this will return a certain customer
    public String employeeID(@PathVariable int id, Model model) {
        Employee employee = this.employeeRepository.findById(id).get();
        model.addAttribute("actors", employee);
        return "employee";
    }

    @GetMapping("/employee/update/{id}") // this will update
    public String employeeUpdateByID(@PathVariable int id, Model model) {
        Employee employee = this.employeeRepository.findById(id).get();
        this.employeeRepository.delete(employee);
        return "employee";
    }

    @GetMapping("/employee/delete/{id}") // this will delete
    public String employeeDeleteByID(@PathVariable int id, Model model) {
        Employee employee = this.employeeRepository.findById(id).get();
        this.employeeRepository.delete(employee);
        return "employee";
    }
}
