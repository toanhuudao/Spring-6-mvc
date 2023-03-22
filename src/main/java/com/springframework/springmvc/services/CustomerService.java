package com.springframework.springmvc.services;

import com.springframework.springmvc.models.Beer;
import com.springframework.springmvc.models.Customer;

import java.util.List;
import java.util.UUID;

public interface CustomerService {
    List<Customer> listCustomers();

    Customer getCustomerById(UUID id);
}
