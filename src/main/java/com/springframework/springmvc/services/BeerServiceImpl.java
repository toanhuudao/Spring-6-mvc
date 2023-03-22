package com.springframework.springmvc.services;

import com.springframework.springmvc.models.Beer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class BeerServiceImpl implements BeerService {

    @Override
    public Beer getBeerById(UUID id) {
        return Beer.builder().id(id)
                .version(1)
                .beerName("CS")
                .upc("1231")
                .price(new BigDecimal("12,99"))
                .quantityOnHand(200)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }
}
