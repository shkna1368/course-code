package com.mapsa.store.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedInhcat implements ApplicationRunner {
@Autowired
CategoryRepository categoryRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Category category = categoryRepository.findById(13L).get();

        category.setTitle("cat updated for version3");
        categoryRepository.save(category);
        Category cat=new Category();
        cat.setTitle("catInh1"+System.currentTimeMillis());

        categoryRepository.save(cat);



        Category cat2=new Category();
        cat2.setTitle("catInh2"+System.currentTimeMillis());

        categoryRepository.save(cat2);

        System.out.println("finish inh");
        System.out.println("finish  update inh");
    }
}
