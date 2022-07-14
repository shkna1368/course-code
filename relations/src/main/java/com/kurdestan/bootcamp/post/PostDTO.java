package com.kurdestan.bootcamp.post;


import com.kurdestan.bootcamp.employee.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class PostDTO {

 @ApiModelProperty(required = false,hidden = true)
  private Long id;

    @ApiModelProperty(required = true,hidden = false)

    private String title;



}
