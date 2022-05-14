package com.mapsa.firstspringapp.calc;


import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculator {

    @Override
    public int sum(int x, int y) {
        return x + y;
    }

    @Override
    public int minus(int x, int y) {
        return x - y;
    }

}
