package com.mohammad.car.controller;

import com.mohammad.car.entity.Car;
import com.mohammad.car.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    private ICarService carService;

    @Autowired
    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @PutMapping(value = "/save/{catId}")
    public Car save(@RequestBody Car car, @PathVariable Long catId) {


        Car savedCar = carService.add(car, catId);
        return savedCar;
    }


    @PostMapping(value = "/update/{catId}")
    public Car update(@RequestBody Car car, @PathVariable Long catId) {

        Car savedNewCar = carService.update(car, catId);

        return savedNewCar;

    }


    @GetMapping(value = "/getAll")

    public List<Car> getAllData() {

        List<Car> carCategories = carService.getAll();

        return carCategories;


    }

    @GetMapping(value = "/getById/{id}")
    public Car getCarById(@PathVariable Long id) {
        Car car = carService.getById(id);
        return car;

    }

    @DeleteMapping(value = "/deleteById/{id}")
    public ResponseEntity<?> deleteCarById(@PathVariable Long id) {


        carService.deleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping(value = "/paging/{page}/{size}")

    public List<Car> filterByGeare(@PathVariable int page, @PathVariable Integer size) {

        Page<Car> carsPage = carService.getAllByPaging(page, size);

        List<Car> cars = carsPage.getContent();


        return cars;


    }


}
