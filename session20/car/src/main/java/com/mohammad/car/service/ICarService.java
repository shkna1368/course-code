package com.mohammad.car.service;

import com.mohammad.car.entity.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICarService {

    Car add(Car car,Long categoryId);
    Car getById(Long id);


    List<Car> getAll();

    void deleteById(Long id);

    Car update(Car car,Long categoryId);

    Page<Car> getAllByPaging(int page, int size);

}
