package com.mapsa.qualifier.inheritance.joinedtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Component
public class Seedjoin implements ApplicationRunner {
@Autowired
StudenRepositoryRepository studenRepository;


    @Autowired
    TeacherRepository teacherRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
   Student st1=new Student();
   st1.setWantsNewsletter(true);
   st1.setBirthDate(LocalDate.now());
   st1.setFirstName("ali");
   st1.setGender(Person.Gender.MALE);
   st1.setLastName("ahmadi");


   studenRepository.save(st1);


        Teacher t1=new Teacher();
        t1.setField("math");
        t1.setBirthDate(LocalDate.now());
        t1.setFirstName("maryam");
        t1.setGender(Person.Gender.FEMALE);
        t1.setLastName("jamali");

        teacherRepository.save(t1);



List<Student> studentList=studenRepository.findAll();
List<Teacher> teachers=teacherRepository.findAll();


        List<Teacher> teachers2=teacherRepository.findAllByGender(Person.Gender.FEMALE);

        System.out.println(studentList);


    }
}
