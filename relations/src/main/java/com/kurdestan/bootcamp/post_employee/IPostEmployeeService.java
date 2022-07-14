package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.post.Post;

import java.util.List;

public interface IPostEmployeeService {
     PostEmployee save(PostEmployee post);
     void delete(Long id);
     PostEmployee getById(Long id);
    List<PostEmployee> getAll();


}
