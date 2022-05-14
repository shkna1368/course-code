package com.mapsa.qualifier.inheritance.singletable;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class SeedSingleTable implements ApplicationRunner {
@Autowired
MotorcycleeRepository motorcycleeRepository;


    @Autowired
    CarrRepository carrRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Carr car=new Carr();
        car.setLicensePlate("65656");
        car.setRunOnLpg(true);

        carrRepository.save(car);


        Motorcyclee motorcycle=new Motorcyclee();
        motorcycle.setLicensePlate("1111");
        motorcycle.setHasSideCar(true);
        motorcycleeRepository.save(motorcycle);


        List<Motorcyclee> motorcycles=motorcycleeRepository.findAll();
        List<Carr> cars=carrRepository.findAll();


        System.out.println();




    }
}
