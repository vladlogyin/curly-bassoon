package com.sparta.curlybassoon.repositories;

import com.sparta.curlybassoon.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}