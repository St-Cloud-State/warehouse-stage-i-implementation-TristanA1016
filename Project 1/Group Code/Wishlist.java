import java.io.Serializable;
import java.util.LinkedList;

public class Wishlist implements Serializable {
    private static final long serialVersionUID = 5L;
    private String clientID; // ID of the client who owns this wishlist
    private LinkedList<Product> wishlistItems; // List of products in the wishlist

    // Constructor for Wishlist
    public Wishlist(String clientID) {
        this.clientID = clientID;
        this.wishlistItems = new LinkedList<>();
    }

    // Add a product to the wishlist
    public boolean addProduct(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            System.out.println("Invalid product or quantity.");
            return false;
        }

        // Check if product already exists in the wishlist
        for (Product p : wishlistItems) {
            if (p.getProductID() == product.getProductID()) {
                // Update the quantity if the product exists
                p.updateStock(quantity);
                System.out.println("Product already in wishlist. Quantity updated.");
                return true;
            }
        }

        // If product does not exist, add it to the wishlist
        product.updateStock(quantity);
        wishlistItems.add(product);
        System.out.println("Product added to wishlist.");
        return true;
    }

    // Remove a product from the wishlist by product ID
    public boolean removeProduct(int productID) {
        for (Product product : wishlistItems) {
            if (product.getProductID() == productID) {
                wishlistItems.remove(product);
                System.out.println("Product removed from wishlist.");
                return true;
            }
        }
        System.out.println("Product not found in wishlist.");
        return false;
    }

    // Check if a product exists in the wishlist by product ID
    public boolean productExists(int productID) {
        for (Product product : wishlistItems) {
            if (product.getProductID() == productID) {
                return true;
            }
        }
        return false;
    }

    // Update product quantity in the wishlist
    public boolean updateProductQuantity(int productID, int quantity) {
        for (Product product : wishlistItems) {
            if (product.getProductID() == productID) {
                product.updateStock(quantity);
                System.out.println("Product quantity updated in wishlist.");
                return true;
            }
        }
        System.out.println("Product not found in wishlist.");
        return false;
    }

    // Print all products in the wishlist
    public void printWishlist() {
        System.out.println("Wishlist for client ID: " + clientID);
        if (wishlistItems.isEmpty()) {
            System.out.println("Wishlist is empty.");
        } else {
            for (Product product : wishlistItems) {
                System.out.println(product.getProductDetails());
            }
        }
    }

    // Get total number of products in the wishlist
    public int getTotalProducts() {
        return wishlistItems.size();
    }

    // Getter for clientID
    public String getClientID() {
        return clientID;
    }
}
