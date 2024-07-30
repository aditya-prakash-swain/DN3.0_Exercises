package Exercise3;

public class Sorting{
    public static void main(String[] args) {
        Order[] orders = {
            new Order("101", "Alice", 250.50),
            new Order("102", "Bob", 100.00),
            new Order("103", "Charlie", 450.75),
            new Order("104", "Diana", 300.00)
        };

        // Bubble Sort
        Order[] bubbleSortedOrders = orders.clone();
        SortingAlgorithms.bubbleSort(bubbleSortedOrders);
        System.out.println("Bubble Sort:");
        for (Order order : bubbleSortedOrders) {
            System.out.println(order);
        }

        // Quick Sort
        Order[] quickSortedOrders = orders.clone();
        SortingAlgorithms.quickSort(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("\nQuick Sort:");
        for (Order order : quickSortedOrders) {
            System.out.println(order);
        }
    }
}
