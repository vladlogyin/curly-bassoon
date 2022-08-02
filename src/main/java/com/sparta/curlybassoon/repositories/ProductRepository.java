package com.sparta.curlybassoon.repositories;

import com.sparta.curlybassoon.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}