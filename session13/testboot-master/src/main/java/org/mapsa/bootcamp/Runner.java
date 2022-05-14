package org.mapsa.bootcamp;

import com.github.javafaker.Faker;

import java.util.Locale;

public class Runner {

    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("fa"));


    String name = faker.name().fullName(); // Miss Samanta Schmidt
        System.out.println("name:"+name);
    String firstName = faker.name().firstName(); // Emory
        System.out.println("firstName:"+firstName);
    String lastName = faker.name().lastName(); // Barton
        System.out.println("lastName:"+lastName);

    String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        System.out.println("streetAddress:"+streetAddress);

    }
}
