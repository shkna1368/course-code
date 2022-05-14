package com.mohammad.car.repository;

import com.mohammad.car.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends PagingAndSortingRepository <Car,Long>{

Page<Car> findAllByGear(Pageable pageable,Integer gear);
Page<Car> findAllByGear(Integer gear,Pageable pageable);

List<Car> findAllByColorAndGear(String color,Integer gear);

}
