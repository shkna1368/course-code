package com.mapsa.qualifier.inheritance.singletable;
import javax.persistence.*;
import java.util.Objects;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
class Vehiclee {
    @Id
    private String licensePlate;

    public Vehiclee() {}

    public String licensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}