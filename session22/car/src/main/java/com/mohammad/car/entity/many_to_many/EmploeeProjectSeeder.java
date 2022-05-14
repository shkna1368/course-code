package com.mohammad.car.entity.many_to_many;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class EmploeeProjectSeeder implements ApplicationRunner {


    @Autowired
    EmploeeRepository emploeeRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create an employee
        Employee employee = new Employee();
        employee.setFirstName("Ramesh");
        employee.setLastName("Fadatare");

        // Create project1
        Project project = new Project();
        project.setTitle("Employee Management System");

        // Create project2
        Project project1 = new Project();
        project1.setTitle("Content Management System");

        // employee can work on two projects,  Add project references in the employee
        employee.getProjects().add(project);
        employee.getProjects().add(project1);

        // Add employee reference in the projects
        project.getEmployees().add(employee);
        project1.getEmployees().add(employee);

        emploeeRepository.save(employee);
    }
}
