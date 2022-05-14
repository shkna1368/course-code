package net.javaguides.springboot.controller;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

	EmployeeService employeeService;

	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/get-by-id/{id}")
	public Employee get(@PathVariable ( value = "id") long id) {
		
		// get employee from the service
		Employee employee = employeeService.getEmployeeById(id);
		
		// set employee as a model attribute to pre-populate the form
		return employee;
	}
	

		@GetMapping("/getAll")
	public List<Employee> getAll() {

		// get employee from the service
		List<Employee> employees = employeeService.getAllEmployees();

		// set employee as a model attribute to pre-populate the form
		return employees;
	}
@GetMapping("/hi")
	public String sayHi() {
      return "hi";
	}



	

}
