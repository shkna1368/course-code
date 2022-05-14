package com.mapsa.store.product;

import com.mapsa.store.category.Category;
import com.mapsa.store.category.ICategoryService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {

    private ProductRepository productRepository;
    private ICategoryService categoryService;

    public ProductService(ProductRepository productRepository, ICategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    public Product save(Long categoryId, Product product) {

        Category category=categoryService.getById(categoryId) ;

        product.setCategory(category);


        return productRepository.save(product);
    }

    @Override
    @Cacheable(value = "productByCatCach",key = "#catId")
    public List<Product> findbyCategoryId(Long catId) {


        Category category=categoryService.getById(catId) ;


        return productRepository.findAllByCategory(category);
    }

    @Override
    public List<Product> getAll() {
        return (List<Product>) productRepository.findAll();
    }
}
