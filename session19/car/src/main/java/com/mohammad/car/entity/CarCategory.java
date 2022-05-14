package com.mohammad.car.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_car_categories")
public class CarCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany()
    private List<Car> cars;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
