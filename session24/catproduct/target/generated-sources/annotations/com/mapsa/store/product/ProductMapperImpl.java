package com.mapsa.store.product;

import com.mapsa.store.category.CatgoryMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-14T18:50:49+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CatgoryMapper catgoryMapper;

    @Override
    public Product toEntity(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setTitle( productDTO.getTitle() );
        product.setPrice( productDTO.getPrice() );
        product.setColor( productDTO.getColor() );
        product.setCategory( catgoryMapper.toEntity( productDTO.getCategory() ) );

        return product;
    }

    @Override
    public ProductDTO toDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId( product.getId() );
        productDTO.setTitle( product.getTitle() );
        productDTO.setPrice( product.getPrice() );
        productDTO.setColor( product.getColor() );
        productDTO.setCategory( catgoryMapper.toDTO( product.getCategory() ) );

        return productDTO;
    }

    @Override
    public List<ProductDTO> toDTOS(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( toDTO( product ) );
        }

        return list;
    }

    @Override
    public List<Product> toEntities(List<ProductDTO> productDTOS) {
        if ( productDTOS == null ) {
            return null;
        }

        List<Product> list = new ArrayList<Product>( productDTOS.size() );
        for ( ProductDTO productDTO : productDTOS ) {
            list.add( toEntity( productDTO ) );
        }

        return list;
    }
}
