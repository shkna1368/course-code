package org.example.firstspdatabase;

import java.util.List;

public interface ICategoryService {

    Category save(Category category);
    List<Category> getAll();
}
