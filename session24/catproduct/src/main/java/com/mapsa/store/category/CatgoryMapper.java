package com.mapsa.store.category;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatgoryMapper {

    Category toEntity(CategoryDTO categoryDTO);
    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTOs(List<Category> categories);
    List<Category> toEntities(List<CategoryDTO> categoryDTOS);


}
