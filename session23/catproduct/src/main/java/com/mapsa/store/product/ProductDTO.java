package com.mapsa.store.product;

import com.mapsa.store.category.Category;
import com.mapsa.store.category.CategoryDTO;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

public class ProductDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String title;

    @ApiModelProperty(required = true, hidden = false)

    private Long price;

    @ApiModelProperty(required = true, hidden = false)
    private String color;

    @ApiModelProperty(required = false, hidden = true)

    private CategoryDTO category;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}
