package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.common.exception.NotFoundException;
import com.kurdestan.bootcamp.post.IPostService;
import com.kurdestan.bootcamp.post.Post;
import com.kurdestan.bootcamp.post.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostEmployeeService implements IPostEmployeeService {

  private  final PostEmployeeRepository repository;



    @Override
    public PostEmployee save(PostEmployee postEmployee) {

        return repository.save(postEmployee);
    }


    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public PostEmployee getById(Long id) {
        Optional<PostEmployee> optionalPostEmployee=repository.findById(id);

        if (!optionalPostEmployee.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalPostEmployee.get();
    }

    @Override
    public List<PostEmployee> getAll() {
        return (List<PostEmployee>) repository.findAll();
    }


}
