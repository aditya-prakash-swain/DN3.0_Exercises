package com.bookstore;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            if (book.getId().equals(id)) {
                books.set(i, updatedBook);
                return ResponseEntity.ok(updatedBook);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        boolean removed = books.removeIf(book -> book.getId().equals(id));
        if (removed) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private List<Book> books = List.of(
            new Book(1L, "1984", "George Orwell", 15.99, "1234567890"),
            new Book(2L, "To Kill a Mockingbird", "Harper Lee", 12.99, "0987654321"),
            new Book(3L, "Animal Farm", "George Orwell", 10.99, "1122334455"));

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooksByQuery(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author) {

        List<Book> filteredBooks = books.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredBooks);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK) // Customize status to 200 OK
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookWithCustomHeaders(@PathVariable Long id) {
        Optional<Book> book = books.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();

        if (book.isPresent()) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "Book-Info");
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(book.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(Long id) {
        super("Book with ID " + id + " not found.");
    }
}