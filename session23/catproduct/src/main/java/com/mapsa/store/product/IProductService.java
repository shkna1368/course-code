package com.mapsa.store.product;

import java.util.List;

public interface IProductService {

    Product save(Long categoryId,Product product);

    List<Product> findbyCategoryId(Long catId);

    List<Product> getAll();


}
