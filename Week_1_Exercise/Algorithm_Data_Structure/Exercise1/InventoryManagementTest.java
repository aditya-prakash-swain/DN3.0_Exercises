package Exercise1;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


class InventoryManager {
    private Map<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    public void updateProduct(String productId, Product updatedProduct) {
        if (inventory.containsKey(productId)) {
            inventory.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " does not exist.");
        }
    }

    public void displayProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
}



public class InventoryManagementTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();
        boolean running = true;

        while (running) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. Display All Products");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                   
                    System.out.print("Enter Product ID: ");
                    String addId = scanner.nextLine();
                    System.out.print("Enter Product Name: ");
                    String addName = scanner.nextLine();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = scanner.nextInt();
                    System.out.print("Enter Price: ");
                    double addPrice = scanner.nextDouble();
                    scanner.nextLine(); 
                    Product newProduct = new Product(addId, addName, addQuantity, addPrice);
                    manager.addProduct(newProduct);
                    System.out.println("Product added successfully.");
                    break;

                case 2:
                    
                    System.out.print("Enter Product ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter New Product Name: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter New Quantity: ");
                    int updateQuantity = scanner.nextInt();
                    System.out.print("Enter New Price: ");
                    double updatePrice = scanner.nextDouble();
                    scanner.nextLine(); 
                    Product updatedProduct = new Product(updateId, updateName, updateQuantity, updatePrice);
                    manager.updateProduct(updateId, updatedProduct);
                    System.out.println("Product updated successfully.");
                    break;

                case 3:
                
                    System.out.print("Enter Product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteProduct(deleteId);
                    System.out.println("Product deleted successfully.");
                    break;

                case 4:
                  
                    System.out.println("Current Inventory:");
                    manager.displayProducts();
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
