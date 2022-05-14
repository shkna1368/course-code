package org.mapsa.bootcamp;

public class LombokRunner {

    public static void main(String[] args) {
        Student student=new Student();

        student.setAge(200);
        student.setFamily("family");
        student.setName("name");
        System.out.println(student);
    }
}
