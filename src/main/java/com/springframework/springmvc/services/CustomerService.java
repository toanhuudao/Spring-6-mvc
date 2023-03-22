package com.springframework.springmvc.services;

import com.springframework.springmvc.models.Beer;
import com.springframework.springmvc.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> listCustomers();
}
