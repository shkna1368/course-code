package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.post.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEmployeeRepository extends PagingAndSortingRepository<PostEmployee,Long> {


}
