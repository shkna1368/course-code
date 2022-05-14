package com.mohammad.car.hib;

import com.mohammad.car.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedHibernate implements ApplicationRunner {

    @Autowired
    PetService petService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Pet pet1=new Pet("blue","dog");
        petService.save(pet1);;

        System.out.println("done");


        pet1.setColor("red");
        petService.update(pet1);;


      List<Pet> petList =petService.getAll();



      List<Pet> petList2 =petService.getAllWithPaging();


      petService.delete(pet1);

        List<Pet> petListAfterDelete =petService.getAll();




        List<Pet> filterByName =petService.getAllWithName("dog");





        List<Pet> findAll =petService.getAllWithNamedQuery1();





        List<Pet> findByName =petService.getAllWithNamedQuery2("dog");




        System.out.println("finish");

    }
}
