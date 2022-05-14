package com.mapsa.qualifier;

import com.mapsa.qualifier.prim.IStudentService;
import com.mapsa.qualifier.qua.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)



public class Application implements ApplicationRunner {


/*    public Application(@Qualifier("userServiceSecond") IUserService userService, IStudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }*/



    @Autowired
    @Qualifier("userServiceSecond")
    IUserService userService;


    @Autowired
    IStudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userService.add("ali","reza");

        studentService.add();
    }

}
