package com.springframework.springmvc.controller;

import com.springframework.springmvc.models.Beer;
import com.springframework.springmvc.models.Customer;
import com.springframework.springmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomer(){
        log.debug("Get list customers- in controller");
        return customerService.listCustomers();
    }
    @RequestMapping(value = "/{customerId}", method = RequestMethod.GET)
    Customer getCustomerById(@PathVariable("customerId") UUID customerId){
        log.debug("Get customer by Id - in controller");
        return customerService.getCustomerById(customerId);
    }

    @PostMapping
    public ResponseEntity handlePost(Customer customer){
        Customer saveCustomer = customerService.saveNewCustomer(customer);
        log.debug("handle Post - in controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/"+ saveCustomer.getId().toString());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
