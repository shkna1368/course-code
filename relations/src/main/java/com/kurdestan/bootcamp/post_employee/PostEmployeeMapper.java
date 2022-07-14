package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.employee.EmployeeMapper;
import com.kurdestan.bootcamp.post.PostMapper;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EmployeeMapper.class, PostMapper.class})
public interface PostEmployeeMapper {

    PostEmployee toPostEmployee(PostEmployeeDTO postEmployeeDTO);
    PostEmployeeDTO toPostEmployeeDTO(PostEmployee postEmployee);
    List<PostEmployee> toPostEmployeeList(List<PostEmployeeDTO> postEmployeeDTOS);
    List<PostEmployeeDTO> toPostEmployeeDTOs(List<PostEmployee> postEmployees);

}
