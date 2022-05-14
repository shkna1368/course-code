package com.shabab.microthree;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController

public class Application {

    @Autowired
    ServiceTest serviceTest;
    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping(value = "/hi/{id}")
    public String sayHi(@PathVariable Long id){
        logger.info("COLLECTING  ID {} FROM UPSTREAM SERVICE", id);


        return "Hi from microservice 3";

    }
    @GetMapping(value = "/hi2/{id}")
    public String sayHi2(@PathVariable Long id){
        logger.info("COLLECTING  ID {} FROM UPSTREAM SERVICE", id);

if(id==5){
    throw new NotfoundException("Not found");
}
        return "Hi from microservice 3";

    }
    @GetMapping(value = "/hi3/{id}")
    public String sayHi3(@PathVariable Long id){
        logger.info("COLLECTING  ID {} FROM UPSTREAM SERVICE", id);
return serviceTest.test(id);

    }


}
