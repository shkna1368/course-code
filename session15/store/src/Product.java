import java.util.Date;

public class Product {



    private Long id;
    private String title;

    private Long price;
    private Category category;
    private int stockCount;

    private Date createdDate;

    public Product(Long id, String title, Long price, Category category, int stockCount,Date createdDate) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.category = category;
        this.stockCount = stockCount;
        this.createdDate=createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getStockCount() {
        return stockCount;
    }

    public void setStockCount(int stockCount) {
        this.stockCount = stockCount;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", category=" + category +
                ", stockCount=" + stockCount +
                ", createdDate=" + createdDate +
                '}';
    }
}
