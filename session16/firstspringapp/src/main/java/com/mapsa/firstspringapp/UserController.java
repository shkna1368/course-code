package com.mapsa.firstspringapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @PostMapping(value = "/add")
    public String add(@RequestBody User user){

        return "added";
    }
    @GetMapping(value = "/get-by-id/{id}")
    public String add(@PathVariable Long id){

        return "mnsbda";
    }
}
