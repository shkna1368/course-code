package com.mapsa.qualifier.aop;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService
{
    public Employee createEmployee( String empId, String fname, String sname)
    {

        Employee emp = new Employee();
        emp.setEmpId(empId);
        emp.setFirstName(fname);
        emp.setSecondName(sname);
        System.out.println("in EmployeeService");
        return emp;
    }
    public void deleteEmployee(String empId)
    {
    }
}