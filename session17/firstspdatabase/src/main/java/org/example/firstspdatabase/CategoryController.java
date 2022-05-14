package org.example.firstspdatabase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/save")

    public Category saveCategory(@RequestBody Category category){

        return  categoryService.save(category);
    }


    @GetMapping(value = "/getAll")

    public List<Category> getAll(){

        return  categoryService.getAll();
    }





}
