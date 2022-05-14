package com.mapsa.springvaadin.service;



import com.mapsa.springvaadin.dto.Car;
import com.mapsa.springvaadin.dto.CarCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

//@FeignClient(name = "mdms-post",url = "${mdms-base-url.ribbon.server-list}")
@FeignClient(name = "car",url = "http://localhost:9090/carcategory")
public interface CarServiceProxy {

  /*  @PostMapping(value ="/car/search")
    String getAllMdmsPosts(@RequestHeader("Authorization")String token,@RequestBody SearchDTO.SearchRq filter);
*/

    @GetMapping("/getAll")
    List<CarCategory> getAllCat();


    @PutMapping("/save")
    void save(CarCategory category);





}
