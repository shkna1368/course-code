package com.saba.carmanagment.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CarDTO {

    @ApiModelProperty(required = false, hidden = true)
    private Long id;

    @ApiModelProperty(required = true, hidden = false)
    private String model;

    @ApiModelProperty(required = true, hidden = false)
    private Integer speed;




}
