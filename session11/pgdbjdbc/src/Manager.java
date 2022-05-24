import java.sql.SQLException;
import java.util.List;

public class Manager {
    public static void main(String[] args) throws SQLException {
        DatabaseConnector ds=new DatabaseConnector();
        ds.connect();


/*
        System.out.println("--------");
       long id= ds.insert(2,"Ali",28);
        System.out.println("id is="+id);
        */


/*

        Student st=new Student();
        st.setId(2);
        st.setName("Alireza");


        ds.update(st);
*/

        List<Student> all = ds.getAll();
        System.out.println(all);

        List<Student> filterData = ds.filterByAge();
        System.out.println("filter:"+filterData);



    }
}
