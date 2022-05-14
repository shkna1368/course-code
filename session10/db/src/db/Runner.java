package db;

import java.sql.SQLException;
import java.util.List;

public class Runner {
    public static void main(String[] args) throws SQLException {
            DataSource dataSource=new DataSource();
           // dataSource.connect();



            Student student=new Student();
            student.setAge(28);
            student.setId(1);
            student.setName("Ali");


        long ids=    dataSource.insertStudent(student);
        System.out.println(ids);
      /*  student.setName("Alireza");


        dataSource.updateName(ids,student);


      Student st=  dataSource.findById(1);


        List<Student> students = dataSource.filterByAge(25);
        System.out.println(students);
*/

    }
}
