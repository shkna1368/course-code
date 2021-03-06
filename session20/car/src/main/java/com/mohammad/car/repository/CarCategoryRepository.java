package com.mohammad.car.repository;

import com.mohammad.car.entity.Car;
import com.mohammad.car.entity.CarCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarCategoryRepository extends PagingAndSortingRepository <CarCategory,Long>{


}
