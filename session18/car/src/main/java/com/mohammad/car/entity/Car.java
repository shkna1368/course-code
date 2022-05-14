package com.mohammad.car.entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "gear",nullable = true)
 private Integer gear;


      @Column(name = "color")
 private String color;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getGear() {
        return gear;
    }

    public void setGear(Integer gear) {
        this.gear = gear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
