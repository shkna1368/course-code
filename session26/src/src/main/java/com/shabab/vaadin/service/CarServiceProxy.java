package com.shabab.vaadin.service;


import com.shabab.vaadin.dto.CarCategory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

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
