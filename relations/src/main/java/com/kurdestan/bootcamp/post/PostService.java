package com.kurdestan.bootcamp.post;

import com.kurdestan.bootcamp.common.SearchCriteria;
import com.kurdestan.bootcamp.common.exception.NotFoundException;
import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.EmployeeRepository;
import com.kurdestan.bootcamp.employee.EmployeeSpecification;
import com.kurdestan.bootcamp.employee.IEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService implements IPostService {

  private  final PostRepository repository;



    @Override
    public Post save(Post post) {

        return repository.save(post);
    }


    @Override
    public void delete(Long id) {


        repository.deleteById(id);
    }

    @Override
    public Post getById(Long id) {
        Optional<Post> optionalPost=repository.findById(id);

        if (!optionalPost.isPresent()){

            throw new NotFoundException("Not Found");
        }


        return optionalPost.get();
    }

    @Override
    public List<Post> getAll() {
        return (List<Post>) repository.findAll();
    }


}
