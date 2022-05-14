package com.mapsa.store;


import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableAdminServer
@EnableJpaAuditing


public class Application implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(Application.class);
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("info log");
        logger.warn("warn log");
        logger.error("error log");
        logger.trace("trac log");
        logger.debug(" log");
    }
}
