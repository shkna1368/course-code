public class Manager {
    public static void main(String[] args) {
        DatabaseConnector ds=new DatabaseConnector();
        ds.connect();

        System.out.println("--------");
       long id= ds.insert(2,"Ali",28);
        System.out.println("id is="+id);
    }
}
