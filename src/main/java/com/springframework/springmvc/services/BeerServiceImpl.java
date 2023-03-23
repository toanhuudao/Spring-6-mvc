package com.springframework.springmvc.services;

import com.springframework.springmvc.models.Beer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private final Map<UUID, Beer> beerMap;

    public BeerServiceImpl(){
        this.beerMap = new HashMap<>();
        Beer b1 = Beer.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("CS")
                .upc("1231")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(1)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer b2 = Beer.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("CS")
                .upc("1231")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(1)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        Beer b3 = Beer.builder().id(UUID.randomUUID())
                .version(1)
                .beerName("CS")
                .upc("1231")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(1)
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(b1.getId(), b1);
        beerMap.put(b2.getId(), b2);
        beerMap.put(b3.getId(), b3);

        log.debug(beerMap.toString());
    }
@Override
    public List<Beer> listBeer(){
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Beer getBeerById(UUID id) {
        return beerMap.get(id);
    }

    @Override
    public Beer saveNewBeer(Beer beer) {
        Beer saveBeer = Beer.builder()
                .id(UUID.randomUUID())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .quantityOnHand(beer.getQuantityOnHand())
                .upc(beer.getUpc())
                .price(beer.getPrice())
                .build();

        beerMap.put(saveBeer.getId(),saveBeer);
        return saveBeer;
    }
}
