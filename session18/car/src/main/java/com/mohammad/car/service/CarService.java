package com.mohammad.car.service;

import com.mohammad.car.entity.Car;
import com.mohammad.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class CarService implements ICarService{
    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car add(Car car) {

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
    public Car update(Car car) {
      Car lastSavedCar= getById(car.getId()) ;
      lastSavedCar.setColor(car.getColor());
      lastSavedCar.setGear(car.getGear());

        Car newSavedCar = carRepository.save(lastSavedCar);


        return newSavedCar;
    }
}
