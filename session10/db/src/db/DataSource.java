package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private final String url = "jdbc:postgresql://localhost:5432/trdb";
    private final String user = "postgres";
    private final String password = "Shkna1368";

    private Connection conn = null;

    public DataSource() {
        conn = connect();
    }

    private Connection connect() {

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }


    long getMaxId() {

        String query = "SELECT MAX(id) as maxvalue FROM students";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(query);
            ResultSet res = pstmt.executeQuery();

            res.next();
            return res.getLong("maxvalue");
        } catch (SQLException e) {
            e.printStackTrace();

        }

        return -1;

    }


    public long insertStudent(Student student) {
        String SQL = "INSERT INTO students(id,name,age) "
                + "VALUES(?,?,?)";

        long id = 0;

        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);
            long lastId = getMaxId();

            if (lastId == 0) {
                System.out.println(lastId);
            }
            pstmt.setLong(1, lastId + 1);
            pstmt.setString(2, student.getName());
            pstmt.setInt(3, student.getAge());

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        id = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    }

    public int updateName(long id, Student student) {
        String SQL = "UPDATE students "
                + "SET name = ? "
                + "WHERE id = ?";

        int affectedrows = 0;

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setString(1, student.getName());
            pstmt.setLong(2,id);

            affectedrows = pstmt.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectedrows;

    }


     public List<Student> filterByAge(int filteredAge) {

         List<Student> students=new ArrayList<>();
        String SQL = "SELECT  * from students "
                + "WHERE age >= ?";



        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {

            pstmt.setLong(1,filteredAge);

            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                //Display values
           long id=    resultSet.getLong("id");
         int age=     resultSet.getInt("age");
          String name=     resultSet.getString("name");


          Student student=new Student();
          student.setAge(age);
          student.setId(id);
          student.setName(name);

          students.add(student);

            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return students;

    }


     public List<Student> getAll() throws SQLException {

         List<Student> students=new ArrayList<>();
        String SQL = "SELECT  * from students ";


         PreparedStatement pstmt = null;
         try {
             pstmt = conn.prepareStatement(SQL);
         } catch (SQLException e) {
             e.printStackTrace();
         }


         ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()){
                //Display values
           long id=    resultSet.getLong("id");
         int age=     resultSet.getInt("age");
          String name=     resultSet.getString("name");


          Student student=new Student();
          student.setAge(age);
          student.setId(id);
          student.setName(name);

          students.add(student);

            }


        return students;

    }






 public Student findById(long id ) throws SQLException {
        String SQL = "SELECT  * from students "
                + "WHERE id = ?";




             PreparedStatement pstmt = conn.prepareStatement(SQL);

         pstmt.setLong(1, id);

         ResultSet resultSet = pstmt.executeQuery();
         Student student = null;
         while (resultSet.next()) {
             //Display values
             long ids = resultSet.getLong("id");
             int age = resultSet.getInt("age");
             String name = resultSet.getString("name");


             student = new Student();
             student.setAge(age);
             student.setId(ids);
             student.setName(name);
             return student;

         }
         return null;


     }





 }
