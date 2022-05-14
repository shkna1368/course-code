package com.saba.carmanagment.repository;

import com.saba.carmanagment.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository  extends PagingAndSortingRepository<Car,Long> {

    Optional<Car> findById (Long id);

    List<Car> findAll();


    Page<Car> findAll(Pageable pageable);


    void deleteById(Long id);
}
