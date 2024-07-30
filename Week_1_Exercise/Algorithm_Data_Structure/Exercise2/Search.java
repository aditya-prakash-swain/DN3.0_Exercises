package Exercise2;

import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        // Create an array of products
        Product[] products = {
            new Product("3", "Tablet", "Electronics"),
            new Product("1", "Laptop", "Electronics"),
            new Product("4", "Smartwatch", "Electronics"),
            new Product("2", "Smartphone", "Electronics")
        };

        SearchAlgorithms.sortProducts(products);

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter I id to search: ");
        String searchId1 = sc.next(); 
        System.out.print("Enter II id to search: ");
        String searchId2 = sc.next();
        sc.close();

        // Linear Search
        
        System.out.println("Linear Search:");
        Product resultLinear1 = SearchAlgorithms.linearSearch(products, searchId1);
        if (resultLinear1 != null) {
            System.out.println("Found: " + resultLinear1);
        } else {
            System.out.println("Product with ID " + searchId1 + " not found.");
        }

        Product resultLinear2 = SearchAlgorithms.linearSearch(products, searchId2);
        if (resultLinear2 != null) {
            System.out.println("Found: " + resultLinear2);
        } else {
            System.out.println("Product with ID " + searchId2 + " not found.");
        }

        // Binary Search
        System.out.println("\nBinary Search:");
        Product resultBinary1 = SearchAlgorithms.binarySearch(products, searchId1);
        if (resultBinary1 != null) {
            System.out.println("Found: " + resultBinary1);
        } else {
            System.out.println("Product with ID " + searchId1 + " not found.");
        }

        Product resultBinary2 = SearchAlgorithms.binarySearch(products, searchId2);
        if (resultBinary2 != null) {
            System.out.println("Found: " + resultBinary2);
        } else {
            System.out.println("Product with ID " + searchId2 + " not found.");
        }
    }
}

