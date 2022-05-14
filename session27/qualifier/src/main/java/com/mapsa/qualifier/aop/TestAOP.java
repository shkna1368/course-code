package com.mapsa.qualifier.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestAOP implements ApplicationRunner {

    @Autowired
    EmployeeService employeeService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        employeeService.createEmployee("1","ali","ji");

    }
}
