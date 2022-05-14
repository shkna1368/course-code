package com.mapsa.qualifier.inheritance.onetableperclass;

import com.mapsa.qualifier.inheritance.joinedtable.*;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SeedOneTablePerClass implements ApplicationRunner {
@Autowired
CarRepository carRepository;


    @Autowired
    MotorCycleRepository motorCycleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
   Car car=new Car();
   car.setLicensePlate("65656");
   car.setRunOnLpg(true);

   carRepository.save(car);


   Motorcycle motorcycle=new Motorcycle();
   motorcycle.setLicensePlate("1111");
   motorcycle.setHasSideCar(true);
   motorCycleRepository.save(motorcycle);


   List<Motorcycle> motorcycles=motorCycleRepository.findAll();
   List<Car> cars=carRepository.findAll();


        System.out.println();



    }
}
