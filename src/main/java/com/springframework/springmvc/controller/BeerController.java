package com.springframework.springmvc.controller;

import com.springframework.springmvc.models.Beer;
import com.springframework.springmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {
    private final BeerService beerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Beer> listBeer(){
        log.debug("Get list beers- in controller");
        return beerService.listBeer();
    }
    @RequestMapping(value = "/{beerId}", method = RequestMethod.GET)
   Beer getBeerById(@PathVariable("beerId") UUID beerId){
        log.debug("Get beer by Id - in controller");
        return beerService.getBeerById(beerId);
    }


}
