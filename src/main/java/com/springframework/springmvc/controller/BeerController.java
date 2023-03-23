package com.springframework.springmvc.controller;

import com.springframework.springmvc.models.Beer;
import com.springframework.springmvc.services.BeerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
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

    @PostMapping
    public ResponseEntity handlePost(Beer beer){
        Beer saveBeer = beerService.saveNewBeer(beer);
        log.debug("handle Post - in controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+ saveBeer.getId().toString());
        return new ResponseEntity(headers,HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateById(@PathVariable("beerId") UUID beerId, @RequestBody Beer beer){
        Beer saveBeer = beerService.updateById(beerId,beer);
        log.debug("handle Post - in controller");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/beer/"+ saveBeer.getId().toString());
        return new ResponseEntity(headers,HttpStatus.OK);
    }


    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteById(@PathVariable("beerId") UUID beerId){
       beerService.deletedById(beerId);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity(headers,HttpStatus.NO_CONTENT);
    }
}
