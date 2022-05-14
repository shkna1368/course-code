package com.mapsa.qualifier.inheritance.onetableperclass;

import javax.persistence.Entity;

@Entity
class Motorcycle extends Vehicle {
    private boolean hasSideCar;

    public boolean isHasSideCar() {
        return hasSideCar;
    }

    public void setHasSideCar(boolean hasSideCar) {
        this.hasSideCar = hasSideCar;
    }
}