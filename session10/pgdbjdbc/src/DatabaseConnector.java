import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
  private   Connection conn=null;

    public DatabaseConnector() {
      connect();
    }

    public void connect(){
        String url = "jdbc:postgresql://localhost:5432/studentdb";
         String user = "postgres";
         String password = "Shkna1368";
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }




    }

    public long insert(String name,int age){
long dbId=0;

        String SQL = "INSERT INTO tbl_students(name,age) "
                + "VALUES(?,?)";



        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);


            pstmt.setString(1, name);
            pstmt.setInt(2, age);

            int affectedRows = pstmt.executeUpdate();
            // check the affected rows
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        dbId = rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return dbId;




    }

    public int updateName(long id, Student student) {
        String SQL = "UPDATE tbl_students "
                + "SET name = ? "
                + "WHERE id = ?";

        int affectedrows = 0;

        try {

             PreparedStatement pstmt = conn.prepareStatement(SQL) ;

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
        String SQL = "SELECT  * from tbl_students "
                + "WHERE age >= ?";



        try {


             PreparedStatement pstmt = conn.prepareStatement(SQL);

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


    public List<Student> getAll()  {

        List<Student> students=new ArrayList<>();
        String SQL = "SELECT  * from tbl_students ";


        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        ResultSet resultSet = null;
        try {
            resultSet = pstmt.executeQuery();


            while (resultSet.next()) {
                //Display values
                long id = resultSet.getLong("id");
                int age = resultSet.getInt("age");
                String name = resultSet.getString("name");


                Student student = new Student();
                student.setAge(age);
                student.setId(id);
                student.setName(name);

                students.add(student);
            }
        }
        catch (SQLException e) {
                e.printStackTrace();
            }



        return students;

    }






    public Student findById(long id ) throws SQLException {
        String SQL = "SELECT  * from tbl_students "
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
