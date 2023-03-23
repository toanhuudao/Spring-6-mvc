package com.springframework.springmvc.services;

import com.springframework.springmvc.models.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeer();

    Beer getBeerById(UUID id);

    Beer saveNewBeer(Beer beer);

    Beer updateById(UUID id, Beer beer);
    void deletedById(UUID beerId);
}
