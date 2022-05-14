package com.saba.carmanagment.service;

import com.saba.carmanagment.entity.Car;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICarService {

    Car addNewCar(Car car);
    Car updateNewCar(Car car);
    List<Car> getAll();
    Car getById(Long id);
    void deletById(Long id);
    Page<Car> getAll(int page, int pageSize);

}
