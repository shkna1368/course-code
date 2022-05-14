package org.example.firstspdatabase;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoryService implements ICategoryService {

  private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);

    }

    @Override
    public List<Category> getAll() {
        return (List<Category>) categoryRepository.findAll();
    }
}
