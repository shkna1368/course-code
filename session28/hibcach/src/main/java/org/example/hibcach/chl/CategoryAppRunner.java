package org.example.hibcach.chl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class CategoryAppRunner implements ApplicationRunner {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

      /*  Category category=new Category();
        category.setTitle("Cat1");*/


   /*   Long id=  categoryRepository.save(category).getId();

      categoryRepository.findById(id);
      categoryRepository.findById(id);
      categoryRepository.findById(id);
      categoryRepository.findById(id);
      categoryRepository.findById(id);*/

    }
}
