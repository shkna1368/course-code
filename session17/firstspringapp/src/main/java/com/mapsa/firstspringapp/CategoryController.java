package com.mapsa.firstspringapp;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @PostMapping(value = "/add")
    public String add(@RequestBody Category category) {

        return "added category";
    }

    @GetMapping(value = "/get-by-id/{id}")
    public String add(@PathVariable Long id) {

        return "category";
    }
}
