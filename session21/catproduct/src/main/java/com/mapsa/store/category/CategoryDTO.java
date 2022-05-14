package com.mapsa.store.category;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

public class CategoryDTO {


    @ApiModelProperty(required = false, hidden = true)
    private Long id;


    @ApiModelProperty(required = true, hidden = false)
    private String title;


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
}
