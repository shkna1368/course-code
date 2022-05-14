package com.mohammad.car.service;

import com.mohammad.car.entity.Car;
import com.mohammad.car.entity.CarCategory;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICarCategoryService {

    CarCategory add(CarCategory carCategory);
    CarCategory getById(Long id);


    List<CarCategory> getAll();

    void deleteById(Long id);

    CarCategory update(CarCategory car);

    Page<CarCategory> getAllWithPagination(int page,int size);

}
