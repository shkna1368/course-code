package com.kurdestan.bootcamp.post_employee;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.post.Post;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_posts_employees",uniqueConstraints={
        @UniqueConstraint(columnNames = {"employee_id", "post_id"})})
@Data
public class PostEmployee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;





    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;


    






}
