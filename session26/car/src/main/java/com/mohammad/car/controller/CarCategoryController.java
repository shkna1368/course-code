package com.mohammad.car.controller;

import com.mohammad.car.entity.Car;
import com.mohammad.car.entity.CarCategory;
import com.mohammad.car.service.ICarCategoryService;
import com.mohammad.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carcategory")

public class CarCategoryController {

   private ICarCategoryService carCategoryService;

   @Autowired
    public CarCategoryController(ICarCategoryService carCategoryService) {
        this.carCategoryService = carCategoryService;
    }

    @PutMapping(value = "/save")
    public CarCategory save(@RequestBody CarCategory carCategory){
      CarCategory carCategorySaved=  carCategoryService.add(carCategory);

      return carCategorySaved;

    }



    @PostMapping(value = "/update")
    public CarCategory update(@RequestBody CarCategory carCategory){

      CarCategory savedNewCarCategory=  carCategoryService.update(carCategory);

      return savedNewCarCategory;

    }




    @GetMapping(value = "/getAll")

    public List<CarCategory> getAllData(){

   List<CarCategory>   cars=carCategoryService.getAll()  ;

   return cars;


    }

    @GetMapping(value = "/getById/{id}")
    public CarCategory getCarById(@PathVariable  Long id){
    CarCategory savedCarCategory=   carCategoryService.getById(id);
    return  savedCarCategory;

    }
      @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable  Long id){


       carCategoryService.deleteById(id);

       return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/filter-by-gear/{page}/{size}")

    public List<CarCategory> filterByGeare(@PathVariable int page,@PathVariable int size){

        Page<CarCategory> carsPage=carCategoryService.getAllWithPagination(page,size)  ;

       List<CarCategory> cars= carsPage.getContent();


        return cars;


    }



}
