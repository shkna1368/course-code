import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final String url="jdbc:postgresql://localhost:5432/store_db";
    private final String userName="postgres";
    private final String password="Shkna1368";
    private Connection connection;

    public CategoryDAO() {
        connectToDB();
    }

    public void connectToDB(){

        try {
             connection = DriverManager.getConnection(url, userName, password);
            System.out.println("Successfully connect To DB");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

   public void insert(Category category){
        String sql="INSERT INTO categories(id,title)"+
                "values(?,?)";

       try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);

preparedStatement.setLong(1,category.getId());
preparedStatement.setString(2,category.getTitle());
preparedStatement.executeUpdate();

       } catch (SQLException e) {
           e.printStackTrace();
       }


   }
public  void insertProduct(Product product){

   String sql="INSERT INTO products(id,title,price,category_id,stock_count,created_date)" +
   "values(?,?,?,?,?,?)";


    try {
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

  preparedStatement.setLong(1,product.getId());
  preparedStatement.setString(2,product.getTitle());
  preparedStatement.setLong(3,product.getPrice());
  preparedStatement.setLong(4,product.getCategory().getId());
  preparedStatement.setLong(5,product.getStockCount());
  Date sqlDate=new Date(product.getCreatedDate().getTime());
  preparedStatement.setDate(6,sqlDate);

  preparedStatement.executeUpdate();


    } catch (SQLException e) {
        e.printStackTrace();
    }


}

   public List<Category> getAll(){
List<Category> categories=new ArrayList<>();
     String sql="select * from categories"  ;
       try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);

          ResultSet resultSet = preparedStatement.executeQuery();

          while (resultSet.next()){

            long id=  resultSet.getLong("id");
            String title=  resultSet.getString("title");

            Category category=new Category();
            category.setTitle(title);
            category.setId(id);

            categories.add(category);
          }


       } catch (SQLException e) {
           e.printStackTrace();
       }

return categories;
   }

   public Category getCategoryById( long ids){
     String sql="select * from categories " +
             "where id = ?";
       try {
           PreparedStatement preparedStatement = connection.prepareStatement(sql);
preparedStatement.setLong(1,ids);
          ResultSet resultSet = preparedStatement.executeQuery();

          resultSet.next();

            long id=  resultSet.getLong("id");
            String title=  resultSet.getString("title");

            Category category=new Category();
            category.setTitle(title);
            category.setId(id);

        return  category;


       } catch (SQLException e) {
           e.printStackTrace();
       }

return null;
   }





   public List<Product> getAllProducts(){
     List<Product> products=new ArrayList<>();

        String sql="select * from products";

       try {
           Statement statement  = connection.createStatement();
           ResultSet resultSet = statement.executeQuery(sql);

           while (resultSet.next()) {
               long id = resultSet.getLong("id");
               String title = resultSet.getString("title");
               long price = resultSet.getLong("price");
               long catId = resultSet.getLong("category_id");
               int stockCount = resultSet.getInt("stock_count");
               Date sqlDate = resultSet.getDate("created_date");
               java.util.Date date = new java.util.Date(sqlDate.getTime());


               //fetch cat from categoryDAo by id
              Category category= getCategoryById(catId);
               Product product = new Product(id, title, price, category, stockCount, date);

               products.add(product);
           }




       } catch (SQLException e) {
           e.printStackTrace();
       }

return products;
   }
    public static void main(String[] args) {
        CategoryDAO categoryDAO=new CategoryDAO();
/*

      List<Category> categories=  categoryDAO.getAll();
*/
/*
      Category categoryFake=new Category();
      categoryFake.setId(3l);

      Product product=new Product(1l,"sony",25658l,categoryFake,60,new java.util.Date());
      categoryDAO.insertProduct(product);*/


        System.out.println("All products"+categoryDAO.getAllProducts());

      //  System.out.println("all data:"+categories);
      /*  Category category=new Category();
        category.setId(3l);
        category.setTitle("TV");


        categoryDAO.insert(category);*/
    }
}
