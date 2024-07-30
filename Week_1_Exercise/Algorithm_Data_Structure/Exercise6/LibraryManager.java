package Exercise6;

public class LibraryManager {
    private Book[] books;

    public LibraryManager(Book[] books) {
        this.books = books;
    }

    public Book linearSearchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null; 
    }

    public Book binarySearchByTitle(String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[mid]; 
            } else if (comparison < 0) {
                left = mid + 1; 
            } else {
                right = mid - 1; 
            }
        }

        return null; 
    }
    
    public class LibraryManagementDemo {
        public static void main(String[] args) {
            Book[] books = {
                new Book("B001", "Java Programming", "James Gosling"),
                new Book("B002", "Data Structures", "Robert Lafore"),
                new Book("B003", "Harry Potter and Philosopher's Stone", "J.K. Rowling"),
                new Book("B004", "2 States", "Chetan Bhagat"),
                new Book("B005", "'The Adventures of Tom Sawyer", "Mark Twain")
            };

            LibraryManager manager = new LibraryManager(books);

            System.out.println("Searching for 'Data Structures' using Linear Search:");
            Book book = manager.linearSearchByTitle("Data Structures");
            if (book != null) {
                System.out.println("Found: " + book);
            } else {
                System.out.println("Book not found.");
            }

            System.out.println("\nSearching for '2 States' using Binary Search:");
            book = manager.binarySearchByTitle("2 States");
            if (book != null) {
                System.out.println("Found: " + book);
            } else {
                System.out.println("Book not found.");
            }
        }
    }

}


