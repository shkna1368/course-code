package com.kurdestan.bootcamp.employee_family;

import com.kurdestan.bootcamp.employee.EmployeeMapper;
import com.kurdestan.bootcamp.file_attachment.FileAttachment;
import com.kurdestan.bootcamp.file_attachment.FileAttachmentDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {EmployeeMapper.class})
public interface FamilyMapper {

    Family toFamily(FamilyDTO familyDTO);
    FamilyDTO toFamilyDTO(Family family);
    List<Family> toFamilyList(List<FamilyDTO> familyDTOS);
    List<FamilyDTO> toFamilyDTOs(List<Family> families);

}
