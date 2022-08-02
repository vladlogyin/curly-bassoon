package com.sparta.curlybassoon.repositories;

import com.sparta.curlybassoon.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}