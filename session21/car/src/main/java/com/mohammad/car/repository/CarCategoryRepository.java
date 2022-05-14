package com.mohammad.car.repository;

import com.mohammad.car.entity.CarCategory;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarCategoryRepository extends PagingAndSortingRepository <CarCategory,Long>{


}
