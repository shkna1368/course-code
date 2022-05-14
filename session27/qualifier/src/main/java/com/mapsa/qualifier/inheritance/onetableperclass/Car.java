package com.mapsa.qualifier.inheritance.onetableperclass;

import javax.persistence.Entity;

@Entity
class Car extends Vehicle {
    private boolean runOnLpg;

    public boolean isRunOnLpg() {
        return runOnLpg;
    }

    public void setRunOnLpg(boolean runOnLpg) {
        this.runOnLpg = runOnLpg;
    }
}