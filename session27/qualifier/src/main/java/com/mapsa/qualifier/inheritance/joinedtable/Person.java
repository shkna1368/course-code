package com.mapsa.qualifier.inheritance.joinedtable;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
class Person {
    @Id
    @GeneratedValue
    private Long id;

    private String lastName;

    @Column(name = "FIRST_NAME")
    private String firstName;

    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    private Student.Gender gender;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public enum Gender {
        MALE,
        FEMALE
    }



}