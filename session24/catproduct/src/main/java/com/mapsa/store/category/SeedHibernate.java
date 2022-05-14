/*
package com.mapsa.store.category;

import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedHibernate implements ApplicationRunner {

    @Autowired
    CatServiceHql catServiceHql;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Category category=new Category();
        category.setTitle("catHql2");


        catServiceHql.save(category);;



      List<Category> categories =catServiceHql.getAll();



      List<Category> categories1 =catServiceHql.getAllWithPaging();


     // petService.delete(pet1);





        List<Category> filterByName =catServiceHql.getAllWithName("catHql");





        List<Category> findAll =catServiceHql.getAllWithNamedQuery1();





        List<Category> findByName =catServiceHql.getAllWithNamedQuery2("catHql");




        System.out.println("finish");

    }
}
*/
