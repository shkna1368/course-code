package com.saba.carmanagment.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="TBL_CARS")
@Data
public class Car {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "model",nullable = false)
    private String model;

    @Column(name = "speed",nullable = false)
    private Integer speed;

}
