package com.springframework.springmvc.services;

import com.springframework.springmvc.models.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
