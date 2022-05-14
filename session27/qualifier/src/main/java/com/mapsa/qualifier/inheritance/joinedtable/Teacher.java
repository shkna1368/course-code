package com.mapsa.qualifier.inheritance.joinedtable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TEACHER")

class Teacher extends Person {
    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}