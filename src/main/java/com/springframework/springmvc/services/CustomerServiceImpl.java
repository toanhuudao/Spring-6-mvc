package com.springframework.springmvc.services;

import com.springframework.springmvc.models.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    private final Map<UUID, Customer> customersMap;


    public CustomerServiceImpl() {
        this.customersMap = new HashMap<>();
        Customer c1 = Customer.builder().id(UUID.randomUUID())
                .customerName("C1")
                .version(12)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer c2 = Customer.builder().id(UUID.randomUUID())
                .customerName("C2")
                .version(13)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

        Customer c3 = Customer.builder().id(UUID.randomUUID())
                .customerName("C3")
                .version(14)
                .createdDate(LocalDateTime.now())
                .lastModifiedDate(LocalDateTime.now())
                .build();

       customersMap.put(c1.getId(), c1);
        customersMap.put(c2.getId(), c1);
        customersMap.put(c3.getId(), c1);
    }

    @Override
    public List<Customer> listCustomers(){
        return new ArrayList<>(customersMap.values());
    }
}
