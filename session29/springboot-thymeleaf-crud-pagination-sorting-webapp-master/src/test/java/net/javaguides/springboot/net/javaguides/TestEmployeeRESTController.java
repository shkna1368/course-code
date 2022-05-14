package net.javaguides.springboot.net.javaguides;


import net.javaguides.springboot.controller.EmployeeRestController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestEmployeeRESTController {
    @Autowired
    private MockMvc mvc ;

    @Test
    public void sayHi() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .get("/hi")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("hi")));
               // .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
    }

     @Test
    public void getAllEmployeesAPI() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .get("/getAll")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
               // .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
    }



@Test
    public void getAllEmployeesAPINotFound() throws Exception
    {
        mvc.perform( MockMvcRequestBuilders
                        .get("/getAll2")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
               // .andExpect(MockMvcResultMatchers.jsonPath("$.employees").exists())
               // .andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());
    }


}
