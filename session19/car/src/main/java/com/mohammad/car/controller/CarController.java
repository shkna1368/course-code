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
public class CarController {

    private ICarService carService;

    @Autowired
    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @PutMapping(value = "/save")
    public Car save(@RequestBody Car car) {
        Car savedCar = carService.add(car);

        return savedCar;

    }

    @PostMapping(value = "/update")
    public Car up(@RequestBody Car car) {

        Car savedNewCar = carService.update(car);

        return savedNewCar;

    }


    @GetMapping(value = "/getAll")

    public List<Car> getAllData() {

        List<Car> cars = carService.getAll();

        return cars;


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


    @GetMapping(value = "/filter-by-gear/{gear}/{page}/{size}")

    public List<Car> filterByGeare(@PathVariable Integer gear, @PathVariable int page, @PathVariable int size) {

        Page<Car> carsPage = carService.getAllByGear(page, size, gear);

        List<Car> cars = carsPage.getContent();


        return cars;


    }


}
