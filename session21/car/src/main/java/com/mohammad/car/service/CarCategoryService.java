package com.mohammad.car.service;

import com.mohammad.car.entity.CarCategory;
import com.mohammad.car.repository.CarCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CarCategoryService implements ICarCategoryService{
    private CarCategoryRepository carCategoryRepository;

    @Autowired
    public CarCategoryService(CarCategoryRepository carCategoryRepository) {
        this.carCategoryRepository = carCategoryRepository;
    }

    @Override
    public CarCategory add(CarCategory carCategory) {

        CarCategory savedCarCategory=carCategoryRepository.save(carCategory);
        return savedCarCategory;
    }

    @Override
    public CarCategory getById(Long id) {
        Optional<CarCategory> optionalCar = carCategoryRepository.findById(id);

if(!optionalCar.isPresent()){

    throw new NotFoundException("not found");
}


        return optionalCar.get();
    }

    @Override
    public List<CarCategory> getAll() {

        List<CarCategory> carCategories= (List<CarCategory>) carCategoryRepository.findAll();
        return carCategories;
    }

    @Override
    public void deleteById(Long id) {

        carCategoryRepository.deleteById(id);
    }

    @Override
    public CarCategory update(CarCategory car) {
return null;
    }

    @Override
    public Page<CarCategory> getAllWithPagination(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);

      Page<CarCategory> carPages=  carCategoryRepository.findAll(pageRequest);

        return carPages;
    }
}
