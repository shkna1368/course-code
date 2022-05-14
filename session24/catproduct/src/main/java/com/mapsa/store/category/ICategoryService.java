package com.mapsa.store.category;

import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);
    Category getById(Long categoryId);
    List<Category> getAll();
    void delete(long id);
}
