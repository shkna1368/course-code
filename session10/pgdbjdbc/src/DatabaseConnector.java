import java.sql.*;

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
}
