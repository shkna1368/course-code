package com.mohammad.car.service;

import com.mohammad.car.entity.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICarService {

    Car add(Car car);

    Car getById(Long id);


    List<Car> getAll();

    void deleteById(Long id);

    Car update(Car car);

    Page<Car> getAllByGear(int page, int size, Integer gear);

}
