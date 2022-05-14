package com.mapsa.store.category;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
   private CategoryRepository categoryRepository;


    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
       return categoryRepository.save(category) ;

    }

    @Override
    public Category getById(Long categoryId) {
        Optional<Category> optionalCategory=categoryRepository.findById(categoryId);

        if(!optionalCategory.isPresent()){
            // update in next session
            throw  new RuntimeException();
        }


        return optionalCategory.get();
    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public void delete(long id) {
        categoryRepository.deleteById(id);
    }
}
