package com.sparta.curlybassoon.services;

import com.sparta.curlybassoon.entities.Product;

import java.math.BigDecimal;
import java.util.Map;

public interface BasketService {
    void addProduct(Product product);
    void removeProduct(Product product);
    Map<Product, Integer> getProducts();
    BigDecimal getTotal();
}
