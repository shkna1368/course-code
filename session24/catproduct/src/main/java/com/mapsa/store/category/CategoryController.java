package com.mapsa.store.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import java.util.List;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    private ICategoryService categoryService;


    private CatgoryMapper mapper;

@Autowired
    public CategoryController(ICategoryService categoryService,CatgoryMapper mapper) {
        this.categoryService = categoryService;
        this.mapper=mapper;

    }

    @PutMapping(value = "/")
    public ResponseEntity<Void> save(@RequestBody CategoryDTO categoryDTO) {

Category category=mapper.toEntity(categoryDTO);
         categoryService.save(category);
        return ResponseEntity.status(HttpsURLConnection.HTTP_CREATED).build();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> getById(@PathVariable Long id) {
        Category category = categoryService.getById(id);


        CategoryDTO categoryDTO = mapper.toDTO(category);
        return ResponseEntity.ok(categoryDTO);

    }


    @GetMapping("/")
    public List<CategoryDTO> getAll() {
      List<Category>  categories= categoryService.getAll();

        List<CategoryDTO>  categoryDTOS=mapper.toDTOs(categories);

        return categoryDTOS ;

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {


        categoryService.delete(id);





}









}
