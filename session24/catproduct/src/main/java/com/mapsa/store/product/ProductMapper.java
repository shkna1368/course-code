package com.mapsa.store.product;

import com.mapsa.store.category.CatgoryMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel ="spring",uses = CatgoryMapper.class)
public interface ProductMapper {
    Product toEntity(ProductDTO productDTO);
    ProductDTO toDTO(Product product);
    List<ProductDTO> toDTOS(List<Product> products);
    List<Product> toEntities(List<ProductDTO> productDTOS);
}
