package net.javaguides.springboot.net.javaguides;

import net.javaguides.springboot.SpringbootThymeleafCrudWebAppApplication;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repository.EmployeeRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@ActiveProfiles("test")

public class EmploeeRepositoryTest {

    @Autowired
    EmployeeRepository repository;




      @Test
    public void save() throws Exception {

          Employee employee=new Employee();
String email="vgfcfg";
employee.setEmail(email);
employee.setFirstName("First");
employee.setLastName("last");
Employee employee1=repository.save(employee);


        assertNotNull(employee1);
        Assert.assertEquals(email,employee1.getEmail());
    }
    @Test
    public void myTest() throws Exception {



        List<?> queryResult = repository.findAll();

        assertFalse(queryResult.isEmpty());
        assertNotNull(queryResult.get(0));
    }


}
