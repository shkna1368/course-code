package com.kurdestan.bootcamp.file_attachment;

import com.kurdestan.bootcamp.employee_family.Family;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileAttachmentRepository extends PagingAndSortingRepository<FileAttachment,Long> {


}
