public class Runner {


    public static void main(String[] args) {
        Seeder seeder=new Seeder();
        seeder.seed();

        System.out.println("users:"+seeder.getUserList());
        System.out.println("-----------------");
        System.out.println("categories:"+seeder.getCategoryList());
        System.out.println("-----------------");
        System.out.println("Products:"+seeder.getProductList());
        System.out.println("-----------------");
        System.out.println("basket:"+seeder.getBasketList());



    }
}
