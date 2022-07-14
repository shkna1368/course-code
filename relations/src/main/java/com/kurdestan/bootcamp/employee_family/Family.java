package com.kurdestan.bootcamp.employee_family;

import com.kurdestan.bootcamp.employee.Employee;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "tbl_family",uniqueConstraints={
        @UniqueConstraint(columnNames = {"employee_id", "national_code"})})
@Data
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Column(name = "national_code")
    private String nationalCode;



    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;









}
