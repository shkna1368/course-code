package com.mohammad.car.controller;

import com.mohammad.car.entity.Car;
import com.mohammad.car.service.ICarService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/basket")
public class TestController {

private final String PRODUCT_SERVICE="basketService";
@Autowired
ProductProxy productProxy;





    @GetMapping(value = "/sabad")
    @CircuitBreaker(name=PRODUCT_SERVICE, fallbackMethod = "productFallback")
    public ResponseEntity<String>  getAllData(){

  String response= productProxy.getProduct();
        return new ResponseEntity<String>(response, HttpStatus.OK);



    }



    public ResponseEntity<String> productFallback(Exception e){
        return new ResponseEntity<String>("Product service is down", HttpStatus.OK);

    }


}
