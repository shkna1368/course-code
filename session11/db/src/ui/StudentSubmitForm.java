package ui;

import db.DataSource;
import db.Student;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentSubmitForm {

    DataSource dataSource;
    JTextField  textFieldAge;
    JTextField  textFieldName;


    public StudentSubmitForm() {
       dataSource=new DataSource() ;
        init();

    }

    public long saveStudent(){
        String name=textFieldName.getText();
        int  age=Integer.parseInt(textFieldAge.getText());

        Student student=new Student();

        student.setAge(age);
        student.setName(name);

     long id=   dataSource.insertStudent(student);



return id;


    }


    public void init(){


        JFrame frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(93, 67, 46, 14);
        frame.getContentPane().add(lblName);

          textFieldName = new JTextField();
        textFieldName.setBounds(204, 64, 167, 20);
        frame.getContentPane().add(textFieldName);
        textFieldName.setColumns(10);


        JLabel lblFamily= new JLabel("Age");
        lblFamily.setBounds(93, 100, 46, 14);
        frame.getContentPane().add(lblFamily);






        textFieldAge = new JTextField();
        textFieldAge.setBounds(204, 100, 167, 20);
        frame.getContentPane().add(textFieldAge);
        textFieldAge.setColumns(10);




        JButton btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(e -> {

            long id=    saveStudent();
            JOptionPane.showMessageDialog(null, "Satudent saved by id :"+id);


        });

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnSubmit.setBounds(93, 121, 89, 23);
        frame.getContentPane().add(btnSubmit);
        frame.setVisible(true);
    }



}
