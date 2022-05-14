package com.mapsa.store.product;

import com.mapsa.store.category.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product,Long> {

List<Product>    findAllByCategory(Category category) ;

}
