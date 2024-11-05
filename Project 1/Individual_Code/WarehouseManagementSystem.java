import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;
public class WarehouseManagementSystem implements Serializable {
    private static final long serialVersionUID = 4L;
    private List<Warehouse> warehouseList;
    private List<Client> clientList;
    private int systemID;

    public WarehouseManagementSystem() {
        this.warehouseList = new ArrayList<>();
        this.clientList = new ArrayList<>();
    }

    public boolean addProduct(Warehouse warehouse, Product product) {
        return warehouse.addProduct(product);
    }

    public boolean addClient(Client client) {
        return clientList.add(client);
    }

    public boolean addWarehouse(Warehouse warehouse) {
        return warehouseList.add(warehouse);
    }

    public boolean removeClient(int clientID) {
        return clientList.removeIf(client -> client.getClientID() == clientID);
    }

    public boolean removeProduct(int productID) {
        for (Warehouse warehouse : warehouseList) {
            if (warehouse.removeProduct(productID)) {
                return true;
            }
        }
        return false;
    }

    public boolean removeWarehouse(int warehouseID) {
        return warehouseList.removeIf(warehouse -> warehouse.getID() == warehouseID);
    }

    public boolean addToWishlist(Client client, Product product, int quantity) {
        return client.addProductToWishlist(product, quantity);
    }
    
    public List<Client> getAllClients() {
        return clientList;
    }

   public Iterator<Product> getAllProducts(Warehouse warehouse) {
    return warehouse.getProductList();
    }

    public Product getProductById(int productID) {
        for (Warehouse warehouse : warehouseList) {
            Product product = warehouse.getProductById(productID);
            if (product != null) {
                return product;
            }
        }
        return null;
    }


    public List<Warehouse> getAllWarehouses() {
        return warehouseList;
    }

    public int getSystemID() {
        return systemID;
    }

    public void setSystemID(int systemID) {
        this.systemID = systemID;
    }
}
