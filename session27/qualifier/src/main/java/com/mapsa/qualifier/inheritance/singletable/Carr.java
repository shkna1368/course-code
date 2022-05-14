package com.mapsa.qualifier.inheritance.singletable;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
class Carr extends Vehiclee {

    private boolean runOnLpg;

    public boolean isRunOnLpg() {
        return runOnLpg;
    }

    public void setRunOnLpg(boolean runOnLpg) {
        this.runOnLpg = runOnLpg;
    }
}