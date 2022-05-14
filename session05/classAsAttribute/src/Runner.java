public class Runner {

    public static void main(String[] args) {
        User user=new User();
        user.setName("Ali");
        user.setFamily("ahmadi");
        user.setAge(25);

        Address address=new Address();
        address.setPlak(25);
        address.setStreetName("Parastoo");

        user.setAddress(address);

        System.out.println(user);


        final int x=20;
        
    }
}
