package com.sparta.curlybassoon.repositories;

import com.sparta.curlybassoon.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}