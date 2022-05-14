package ui;

import db.DataSource;
import db.Student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentList {

    DataSource dataSource;


    public StudentList() throws SQLException {
    dataSource=new DataSource() ;

List<Student> students=getStudents();
init(students);
    }

    public List<Student> getStudents() throws SQLException {


    return   dataSource.getAll();




    }


    public void init(List<Student> students){



        DefaultTableModel tableModel = new DefaultTableModel();


        JTable table = new JTable(tableModel);
        tableModel.addColumn("Id");
        tableModel.addColumn("Name");
        tableModel.addColumn("Age");





        students.forEach(student -> {

            Object[] o = new Object[3];
            o[0] = student.getId();
            o[1] = student.getName();
            o[2] = student.getAge();

            tableModel.addRow(o);

        });



        JButton btnSubmit = new JButton("Add student");
        btnSubmit.addActionListener(e -> {

            StudentSubmitForm studentSubmitForm=new StudentSubmitForm();



        });
        btnSubmit.setBounds(93, 250, 89, 23);






        JFrame f = new JFrame();
        f.setSize(550, 350);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(btnSubmit);

        f.add(new JScrollPane(table));
        f.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        StudentList studentList=new StudentList();

    }


}
