package Exercise2;

import java.util.Arrays;

public class SearchAlgorithms {
    // Linear Search Method
    public static Product linearSearch(Product[] products, String searchId) {
        for (Product product : products) {
            if (product.getProductId().equals(searchId)) {
                return product;
            }
        }
        return null; 
    }
    
        // Binary Search Method
        public static Product binarySearch(Product[] products, String searchId) {
            int left = 0;
            int right = products.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                int comparison = products[mid].getProductId().compareTo(searchId);

                if (comparison == 0) {
                    return products[mid];
                } else if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return null; 
        }

        public static void sortProducts(Product[] products) {
            Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));
        }
    }


