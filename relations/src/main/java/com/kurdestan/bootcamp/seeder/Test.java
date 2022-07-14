package com.kurdestan.bootcamp.seeder;

import com.kurdestan.bootcamp.employee.Employee;
import com.kurdestan.bootcamp.employee.EmployeeRepository;
import com.kurdestan.bootcamp.employee.Gender;
import com.kurdestan.bootcamp.employee_family.Family;
import com.kurdestan.bootcamp.employee_family.FamilyRepository;
import com.kurdestan.bootcamp.file_attachment.FileAttachment;
import com.kurdestan.bootcamp.file_attachment.FileAttachmentRepository;
import com.kurdestan.bootcamp.post.Post;
import com.kurdestan.bootcamp.post.PostRepository;
import com.kurdestan.bootcamp.post_employee.PostEmployee;
import com.kurdestan.bootcamp.post_employee.PostEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

//@Component
public class Test implements CommandLineRunner {
   @Autowired
   EmployeeRepository employeeRepository;

     @Autowired
     FileAttachmentRepository fileAttachmentRepository;

     @Autowired
     PostRepository postRepository;

     @Autowired
     FamilyRepository familyRepository;


     @Autowired
     PostEmployeeRepository postEmployeeRepository;



    @Override
    public void run(String... args) throws Exception {

        Employee e1=makeSaveEmployee();
      Family f1=  makeFamily(e1);
      FileAttachment attachment=  msAttac(e1);
      Post p1=makePost();
      PostEmployee postEmployee=makePostEmployee(e1,p1);



      //employeeRepository.delete(e1);
        System.out.println("");
    }

    private Employee makeSaveEmployee(){
        Employee emp1=new Employee();
        emp1.setBirthDay(new Date());
        emp1.setNationalCode("002"+System.currentTimeMillis());
        emp1.setGender(Gender.FEMALE);
        emp1.setIsMarried(false);
        emp1.setName("ali"+System.currentTimeMillis());
        emp1.setFamily("nhbv");

        return employeeRepository.save(emp1);

    }

    private FileAttachment msAttac(Employee employee){
        FileAttachment fileAttachment=new FileAttachment();
        fileAttachment.setEmployee(employee);
        fileAttachment.setLastLicenseImage("e1");
        fileAttachment.setLastLicenseImage("e2");

        return fileAttachmentRepository.save(fileAttachment);
    }

     private Family makeFamily(Employee employee){
      Family family=new Family();
      family.setEmployee(employee);
      family.setNationalCode("6546");
      family.setFullName("hvfghg");

        return familyRepository.save(family);
    }

  private Post makePost(){
      Post post=new Post();
      post.setTitle("tit2");

        return postRepository.save(post);
    }


  private PostEmployee makePostEmployee(Employee employee,Post post){
      PostEmployee postEmployee=new PostEmployee();
      postEmployee.setEmployee(employee);
      postEmployee.setPost(post);

        return postEmployeeRepository.save(postEmployee);
    }


}
