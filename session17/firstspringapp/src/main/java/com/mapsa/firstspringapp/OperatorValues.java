package com.mapsa.firstspringapp;

import java.util.List;

public class OperatorValues {

    private String operator;
    private List<Long> num;


    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<Long> getNum() {
        return num;
    }

    public void setNum(List<Long> num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "OperatorValues{" +
                "operator='" + operator + '\'' +
                ", num=" + num +
                '}';
    }
}
