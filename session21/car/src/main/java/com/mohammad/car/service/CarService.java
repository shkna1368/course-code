package com.mohammad.car.service;

import com.mohammad.car.entity.Car;
import com.mohammad.car.entity.CarCategory;
import com.mohammad.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService{
    private CarRepository carRepository;
    private ICarCategoryService carCategoryService;

    @Autowired
    public CarService(CarRepository carRepository,ICarCategoryService carCategoryService) {
        this.carRepository = carRepository;
       this. carCategoryService=carCategoryService;
    }

    @Override
    public Car add(Car car,Long catId) {


        CarCategory carCategory=carCategoryService.getById(catId);
car.setCategory(carCategory);
        Car savedCar=carRepository.save(car);
        return savedCar;
    }

    @Override
    public Car getById(Long id) {
        Optional<Car> optionalCar = carRepository.findById(id);

if(!optionalCar.isPresent()){

    throw new NotFoundException("not found");
}


        return optionalCar.get();
    }

    @Override
    public List<Car> getAll() {

        List<Car> cars= (List<Car>) carRepository.findAll();
        return cars;
    }

    @Override
    public void deleteById(Long id) {

        carRepository.deleteById(id);
    }

    @Override
    public Car update(Car car,Long catId) {

        CarCategory carCategory=carCategoryService.getById(catId);
        car.setCategory(carCategory);

      Car lastSavedCar= getById(car.getId()) ;
      lastSavedCar.setColor(car.getColor());
      lastSavedCar.setCategory(carCategory);
      lastSavedCar.setGear(car.getGear());

        Car newSavedCar = carRepository.save(lastSavedCar);


        return newSavedCar;
    }

    @Override
    public Page<Car> getAllByPaging(int page, int size) {
        Pageable pageRequest = PageRequest.of(page, size);

      Page<Car> carPages=  carRepository.findAll(pageRequest);

        return carPages;
    }
}
