package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.common.SearchCriteria;
import com.kurdestan.bootcamp.employee.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IPostService {
     Post save(Post post);
     void delete(Long id);
     Post getById(Long id);
    List<Post> getAll();


}
