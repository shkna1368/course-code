package com.mapsa.firstspringapp;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value="/first-controller/")
public class FirstController {


    @GetMapping(value = "/hi")
    public String sayHi(){

        return "Salam";
    }

    @GetMapping(value="/add/{num1}/{num2}")

    public Integer sum(@PathVariable Integer num1, @PathVariable Integer num2 ){

        return  num1+num2;
    }

    @PostMapping(value = "/data")

    public String getData(@RequestBody Map<String,Object> myData){
        int age= (int) myData.get("age");
        return "your age is:"+age;
    }

    @PostMapping(value = "/studentData")

    public String getStudentValues(@RequestBody Student student){
        String name=student.getName();
        Integer age=student.getAge();


        return "Student name is:"  +name+" &age is"+age;


    }
}
