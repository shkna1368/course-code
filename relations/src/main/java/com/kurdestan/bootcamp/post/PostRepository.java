package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.file_attachment.FileAttachment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends PagingAndSortingRepository<Post,Long> {


}
