package com.mapsa.store.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(name = "/product")
public class ProductController {

 IProductService productService;
 ProductMapper productMapper;

    public ProductController(IProductService productService,ProductMapper productMapper) {


        this.productService = productService;
        this.productMapper=productMapper;
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
    public List<ProductDTO> getAll(){
        List<Product> all = productService.getAll();
        List<ProductDTO> productDTOS = productMapper.toDTOS(all);
        return productDTOS ;


    }
}
