package com.saba.carmanagment.service;

import com.saba.carmanagment.entity.Car;
import com.saba.carmanagment.exeption.NotFoundException;
import com.saba.carmanagment.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarService implements ICarService{

private final CarRepository carRepository;



    @Override
    public Car addNewCar(Car car) {
        Car savedCar=carRepository.save(car);
        return savedCar;
    }

    @Override
    public Car updateNewCar(Car car) {
       Long id= car.getId();

      Car lastCar= getById(id);

      lastCar.setModel(car.getModel());
      lastCar.setSpeed(car.getSpeed());



        return carRepository.save(lastCar);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public Car getById(Long id) {

        Optional<Car> optionalCar=carRepository.findById(id);

        if (!optionalCar.isPresent()){
throw new NotFoundException("Not found");
        }
        return optionalCar.get();
    }

    @Override
    public void deletById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public Page<Car> getAll(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(

                Sort.Order.desc("id")
        ));
        Page<Car> carPage = carRepository.findAll(pageable);
        return carPage;

    }
}
