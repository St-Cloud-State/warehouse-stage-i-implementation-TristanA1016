public class Product {
    // attributes
    private int productID;
    private String productName;
    private String description;
    private double price;
    private int stockQuantity;

    // constructor
    public Product(int productID, String productName, String description, double price, int stockQuantity) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    // update stock quantity
    public void updateStock(int amount) {
        this.stockQuantity += amount; 
    }

    // get product details as a formatted string
    public String getProductDetails() {
        return "Product ID: " + productID +
                ", Name: " + productName +
                ", Description: " + description +
                ", Price: $" + price +
                ", Stock Quantity: " + stockQuantity;
    }

    // getter methods
    public int getProductID() {
        return productID;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    // setter methods
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}