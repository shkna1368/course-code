import java.util.List;

public class Manager {
    public static void main(String[] args) {
        DatabaseConnector ds=new DatabaseConnector();


        System.out.println("--------");
    //   long id= ds.insert(2,"Ali",28);
       long id= ds.insert("Ali"+System.currentTimeMillis(),28);
        System.out.println("id is="+id);

      List<Student> studentList= ds.filterByAge(15);
        List<Student> studens=  ds.getAll();



    }
}
