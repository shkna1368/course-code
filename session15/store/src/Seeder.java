import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Seeder {
 private List<User>   userList;
 private List<Category>   categoryList;
 private List<Product>   productList;
 private List<Basket>   basketList;


    public Seeder() {

        userList=new ArrayList<>();
        categoryList=new ArrayList<>();
        productList=new ArrayList<>();
        basketList=new ArrayList<>();
    }

    public void seed(){
        User user1=new User();
        user1.setId(1l);
        user1.setFullName("mariam rajabi");
        user1.setAddress("tohid squre");

        User user2=new User();
        user2.setId(2l);
        user2.setFullName("ahmad rezaee");
        user2.setAddress("azadi squre");

        User user3=new User();
        user3.setId(3l);
        user3.setFullName("shabab koohi");
        user3.setAddress("tarsht");


        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        ////////////////////////make category

        Category cat1=new Category();
        cat1.setId(1l);
        cat1.setTitle("Lebas");


        Category cat2=new Category();
        cat2.setId(2l);
        cat2.setTitle("Phone");


        Category cat3=new Category();
        cat3.setId(3l);
        cat3.setTitle("Laptop");


        categoryList.add(cat1);
        categoryList.add(cat2);
        categoryList.add(cat3);
        ////////////////////
        Product p1=new Product(1l,"Shalvar Lee",229600l,cat1,50,new Date());
        Product p2=new Product(2l,"Hoodi",220000l,cat1,6,new Date());
        Product p3=new Product(3l,"Note 8 Pro",260000l,cat2,25,new Date());
        Product p4=new Product(4l,"Iphone 13",60000l,cat2,30,new Date());
        Product p5=new Product(5l,"MacPro",290000l,cat3,80,new Date());
        Product p6=new Product(6l,"Lenovo",440000l,cat3,90,new Date());

        productList.add(p1);
        productList.add(p2);
        productList.add(p3);
        productList.add(p4);
        productList.add(p5);
        productList.add(p6);
        //////////////////////////////////////


        Basket basket=new Basket();
        basket.setId(1l);
        basket.setUser(user1);
        List<Product> basketItems=new ArrayList<>();
        basketItems.add(p1);
        basketItems.add(p4);
        basketItems.add(p6);
        basket.setProductList(basketItems);
        basket.setDate(new Date());


        Basket basket2=new Basket();
        basket2.setId(2l);
        basket2.setUser(user2);
        List<Product> basketItems2=new ArrayList<>();
        basketItems2.add(p2);
        basketItems2.add(p3);
        basketItems2.add(p5);
        basket2.setProductList(basketItems2);
        basket2.setDate(new Date());


        basketList.add(basket);
        basketList.add(basket2);









    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public List<Basket> getBasketList() {
        return basketList;
    }
}
