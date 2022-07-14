package com.kurdestan.bootcamp.employee_family;


import com.kurdestan.bootcamp.employee.EmployeeDTO;
import com.kurdestan.bootcamp.employee.Gender;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FamilyDTO {

    @ApiModelProperty(required = false,hidden = true)
    private Long id;

    @ApiModelProperty(required = true,hidden = false)
    private String fullName;

    @ApiModelProperty(required = true,hidden = false)
    private String nationalCode;

    @ApiModelProperty(required = true,hidden = false)
    private EmployeeDTO employee;

}
