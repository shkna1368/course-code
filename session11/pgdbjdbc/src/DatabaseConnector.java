import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {
  private   Connection conn=null;

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

    public long insert(int id,String name,int age){
long dbId=0;

        String SQL = "INSERT INTO tbl_students(id,name,age) "
                + "VALUES(?,?,?)";



        try {
            PreparedStatement pstmt = conn.prepareStatement(SQL,
                    Statement.RETURN_GENERATED_KEYS);

            pstmt.setLong(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, age);

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

    public void update(Student student) throws SQLException {
        String sql="UPDATE tbl_students "
                +"SET name= ?"
                +"WHERE id= ?";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        preparedStatement.setString(1,student.getName());
        preparedStatement.setLong(2,student.getId());
        preparedStatement.executeUpdate();
        System.out.println("Successfully update");


    }
    public List<Student> getAll() throws SQLException {

        List<Student> students=new ArrayList<>();
        String SQL = "SELECT  * from tbl_students ";


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
    public List<Student> filterByAge() throws SQLException {

        List<Student> students=new ArrayList<>();
        String SQL = "SELECT  * from tbl_students where age >25 ";


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
}
