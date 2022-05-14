package com.mapsa.firstspringapp;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/first-controller/")
public class FirstController {


    @GetMapping(value = "/hi")
    public String sayHi() {

        return "Salam";
    }

    @GetMapping(value = "/add/{num1}/{num2}")

    public Integer sum(@PathVariable Integer num1, @PathVariable Integer num2) {

        return num1 + num2;
    }

    @GetMapping(value = "/adds")
    public Integer adds(@RequestParam(required = true, name = "num1") Integer number1, @RequestParam(required = true, name = "num2") Integer number2) {

        return number1 + number2;
    }

    @GetMapping(value = "/add2")


    @PostMapping(value = "/data")

    public String getData(@RequestBody Map<String, Object> myData) {
        int age = (int) myData.get("age");
        return "your age is:" + age;
    }

    @PostMapping(value = "/studentData")

    public String getStudentValues(@RequestBody Student student) {
        String name = student.getName();
        Integer age = student.getAge();


        return "Student name is:" + name + " &age is" + age;


    }

    @PostMapping(value = "/studentDataarray")

    public String getStudentValues(@RequestBody List<Student> students) {


        return "Student size  is:" + students.size();


    }

    @PostMapping(value = "/intArray")

    public String getNumbers(@RequestBody List<Integer> numbers) {


        return "Student size  is:" + numbers.size();


    }

    @PostMapping(value = "/stringArray")

    public String getStrs(@RequestBody List<String> strs) {


        return "Student size  is:" + strs.size();


    }

    @PostMapping(value = "/opValues")

    public String getStrs(@RequestBody OperatorValues operatorValues) {


        return "You send:" + operatorValues.toString();


    }


    @PostMapping(value = "/err")

    public String getStrs() {
        int x = 1 / 0;


        return "You send:";


    }


}
