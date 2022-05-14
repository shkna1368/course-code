package com.mohammad.car.loadbalance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RibbonClient(name = "micro1")
public class Micro1Controller {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/getmicro2")
    public String getMicro2Instance()
    {
        String url = "http://micro1/microservice2/port";
        String port = "Currently hitting instance running on port: " +
                restTemplate.getForObject(url, String.class);
        return port;
    }
}