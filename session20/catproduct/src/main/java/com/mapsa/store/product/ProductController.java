package com.mapsa.store.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/product")
public class ProductController {

 IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PutMapping("/{categoryId}")
    public Product save(@RequestBody Product product, @PathVariable Long categoryId){

        return productService.save(categoryId, product);


    }
    @GetMapping("/find-by-category/{categoryId}")
    public List<Product> filter(@PathVariable Long categoryId){

        return productService.findbyCategoryId(categoryId);


    }
    @GetMapping("/getAll")
    public List<Product> getAll(){

        return productService.getAll();


    }
}
