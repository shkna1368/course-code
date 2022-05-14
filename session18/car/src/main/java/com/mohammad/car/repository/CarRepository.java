package com.mohammad.car.repository;

import com.mohammad.car.entity.Car;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends PagingAndSortingRepository <Car,Long>{



}
