package com.mohammad.car.controller;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service",url = "http://localhost:6060/")
//@FeignClient(name = "mdmsArea",url = "http://devapp01.icico.net.ir/master-data")
public interface ProductProxy {


    @GetMapping("/product")
    String getProduct();





}
