package com.mapsa.qualifier.inheritance.joinedtable;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "STUD")
class Student extends Person {
    private boolean wantsNewsletter;

    public boolean isWantsNewsletter() {
        return wantsNewsletter;
    }

    public void setWantsNewsletter(boolean wantsNewsletter) {
        this.wantsNewsletter = wantsNewsletter;
    }
}