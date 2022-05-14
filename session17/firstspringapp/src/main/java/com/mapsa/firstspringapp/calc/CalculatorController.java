package com.mapsa.firstspringapp.calc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    //@Autowired
    private ICalculator calculator;

    @GetMapping(value = "/jam")
    public int sumjam(@RequestParam(name = "num1", required = true) Integer number1, @RequestParam(name = "num2", required = true) Integer number2) {
        return calculator.sum(number1, number2);
    }
    
    @Autowired
    public void setCalculator(ICalculator calculator) {
        this.calculator = calculator;
    }
}
