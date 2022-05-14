package com.mohammad.car;

import com.mohammad.car.entity.Car;
import com.mohammad.car.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class CarSeeder implements ApplicationRunner {
CarRepository carRepository;

@Autowired
    public CarSeeder(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
/*if (carRepository.count()==0) {

    String[] arrayColors = {"red", "blue", "black", "green", "pink", "gold", "silver", "purple"};

    for (int i = 0; i <= 10000; i++) {

        int randomGear = ThreadLocalRandom.current().nextInt(3, 21 + 1);
        int idx = new Random().nextInt(arrayColors.length);
        String randomColor = (arrayColors[idx]);

        Car car = new Car();
        car.setGear(randomGear);
        car.setColor(randomColor);
        Car savedCar = carRepository.save(car);

        System.out.println("id:" + savedCar.getId());

    }
}*/




    }
}
