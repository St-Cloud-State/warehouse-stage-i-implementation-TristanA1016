import java.util.Iterator;

public class WarehouseManagementSystemDriver {
    public static void main(String[] args) {
        WarehouseManagementSystem wms = new WarehouseManagementSystem();
        

        //set up phase 
            System.out.println("\n--- System Set Up ---");
            // Set system ID
            wms.setSystemID(1);
            System.out.println("System ID: " + wms.getSystemID());

            // Create some warehouses
            Warehouse warehouse1 = new Warehouse("New York", "1234 Broadway St");
            Warehouse warehouse2 = new Warehouse("Los Angeles", "5678 Sunset Blvd");
            warehouse1.setID(0);
            warehouse2.setID(1);

            // Add warehouses to the system
            wms.addWarehouse(warehouse1);
            wms.addWarehouse(warehouse2);
            System.out.println("\nAdding Warehouse 1");
            System.out.println("\nAdding Warehouse 2");
            System.out.println("\nAll warehouses in the system:");
            for (Warehouse warehouse : wms.getAllWarehouses()) {
                System.out.println("Warehouse ID: " + warehouse.getID() + ", Location: " + warehouse.getLocation());
            }

            // Create some clients
            Client client1 = new Client(1, "Alice Smith", "123 Maple St", "123-456-7890");
            Client client2 = new Client(2, "Bob Johnson", "456 Oak St", "987-654-3210");

            // Add clients to the system
            wms.addClient(client1);
            wms.addClient(client2);

            // Add products to warehouse1
            System.out.println("\nAdding products to Warehouse 1:");
            boolean added1 = wms.addProduct(warehouse1, new Product(1, "MacBook Air", "Apple notebook", 1199.99, 10));
            boolean added2 = wms.addProduct(warehouse1, new Product(2, "iPhone", "Apple Smartphone", 899.99, 20));
            boolean added3 = wms.addProduct(warehouse1, new Product(3, "Apple Watch", "Smartwatch", 399.99, 30));

             // Display the result of product additions
            System.out.println("Product 1 added: " + added1);
            System.out.println("Product 2 added: " + added2);
            System.out.println("Product 3 added: " + added3);

        //here we begin with more specific testing now that our enviroment has been set up
        
       
                // Wishlist tests
                System.out.println("\n--- Wishlist Tests ---");

                // Add products to client1's wishlist
                System.out.println("Adding products to Client 1's wishlist:");
                boolean wishlistAdd1 = wms.addToWishlist(client1, new Product(1, "MacBook Air", "Apple notebook", 1199.99, 1), 1);
                boolean wishlistAdd2 = wms.addToWishlist(client1, new Product(3, "Apple Watch", "Smartwatch", 399.99, 1), 1);
                
                // Print the result of adding to wishlist
                System.out.println("Product 1 added to wishlist: " + wishlistAdd1);
                System.out.println("Product 3 added to wishlist: " + wishlistAdd2);

                // View client1's wishlist
                System.out.println("\nClient 1's Wishlist:");
                client1.viewWishlist();

                // Add product to client2's wishlist
                System.out.println("\nAdding a product to Client 2's wishlist:");
                boolean wishlistAdd3 = wms.addToWishlist(client2, new Product(2, "iPhone", "Apple Smartphone", 899.99, 1), 1);
                System.out.println(wishlistAdd3);

                // Print client2's wishlist
                System.out.println("\nClient 2's Wishlist:");
                client2.viewWishlist();

                // Remove a product from client1's wishlist
                System.out.println("\nRemoving product with ID 1 (MacBook Air) from Client 1's wishlist");
                boolean wishlistRemove = client1.removeProductFromWishlist(1);
                System.out.println("Product removed from wishlist: " + wishlistRemove);

                // View client1's wishlist after removal
                System.out.println("\nClient 1's Wishlist after removal:");
                client1.viewWishlist();
            
            // --- Product Tests ---
            System.out.println("\n--- Product Tests ---");

            // Modify product details in warehouse1
            System.out.println("\nModifying Product 1 (MacBook Air) in Warehouse 1");
            Product macbook = wms.getProductById(1);
            System.out.println("Product before change: " + macbook.getProductDetails());
            macbook.setPrice(1099.99);  // Change price
            macbook.setDescription("Apple notebook - Updated");

            // Display updated product details
            System.out.println("Updated Product 1 details:");
            System.out.println(macbook.getProductDetails());

            // Display all products in warehouse1 after modifications
            System.out.println("\nProducts in Warehouse 1 after modifications:");
            Iterator<Product> productsIterator1 = wms.getAllProducts(warehouse1);
            while (productsIterator1.hasNext()) {
                Product product = productsIterator1.next();
                System.out.println(product.getProductDetails());
            }

            // --- Client Tests ---
            System.out.println("\n--- Client Tests ---");
            System.out.println("\nclient info before change: "+ client1.toString());
            // Modify client1's information
            System.out.println("\nUpdating Client 1's information");
            client1.setName("Alice Johnson");
            client1.setAddress("789 Pine St");
            client1.setContact("555-111-2222");

            // Display updated client1 details
            System.out.println("Updated Client 1 details:");
            System.out.println(client1);

            // Display all clients in the system after modification
            System.out.println("\nAll clients in the system after modifications:");
            for (Client client : wms.getAllClients()) {
                System.out.println(client);
            }
            
            System.out.println("\n--- Warehouse Tests ---");
            // Display all products in warehouse1
            System.out.println("\nProducts in Warehouse 1:");
            Iterator<Product> productsIterator = wms.getAllProducts(warehouse1);
            while (productsIterator.hasNext()) {
                Product product = productsIterator.next();
                System.out.println(product.getProductDetails());
            }



            // Remove a product from warehouse1
            System.out.println("\nRemoving product with ID 2 (iPhone) from Warehouse 1");
            boolean removed = wms.removeProduct(2);
            System.out.println("Product removed: " + removed);
            
            // Display all products after removal
            System.out.println("\nProducts in Warehouse 1 after removal:");
            productsIterator = wms.getAllProducts(warehouse1);
            while (productsIterator.hasNext()) {
                Product product = productsIterator.next();
                System.out.println(product.getProductDetails());
            }

            // Remove a client from the system
            System.out.println("\nRemoving client with ID 1 (Alice Smith)");
            boolean clientRemoved = wms.removeClient(1);
            System.out.println("Client removed: " + clientRemoved);

            // Display all clients
            System.out.println("\nAll clients in the system:");
            for (Client client : wms.getAllClients()) {
                System.out.println(client);
            }

            // Remove a warehouse
            System.out.println("\nRemoving Warehouse 2.");
            boolean warehouseRemoved = wms.removeWarehouse(warehouse2.getID());
            System.out.println("Warehouse removed: " + warehouseRemoved);

            // Display all warehouses
            System.out.println("\nAll warehouses in the system:");
            for (Warehouse warehouse : wms.getAllWarehouses()) {
                System.out.println("Warehouse ID: " + warehouse.getID() + ", Location: " + warehouse.getLocation());
            }
        }
}
