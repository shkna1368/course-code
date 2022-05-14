package com.shabab.microthree;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
@EnableAdminServer

public class Application {
    private Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @GetMapping(value = "/hi/{id}")
    public String sayHi(@PathVariable Long id){
        logger.info("COLLECTING  ID {} FROM UPSTREAM SERVICE", id);


        return "Hi from microservice 3";

    }
}
