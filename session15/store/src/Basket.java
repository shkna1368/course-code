import java.util.Date;
import java.util.List;

public class Basket {
    private Long id;
    private List<Product> productList;
    private Date date;
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", productList=" + productList +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
