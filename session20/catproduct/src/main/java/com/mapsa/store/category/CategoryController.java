package com.mapsa.store.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/category")
public class CategoryController {
    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PutMapping()
    public Category save(@RequestBody Category category) {


        return categoryService.save(category);

    }

    @GetMapping(value = "/{id}")
    public Category getById(@PathVariable Long id) {


        return categoryService.getById(id);

    }


    @GetMapping()
    public List<Category> getAll() {


        return categoryService.getAll();

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {


        categoryService.delete(id);





}









}
