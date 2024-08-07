package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    // Setter method for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayRepositoryStatus() {
        // Example method to demonstrate usage
        System.out.println("BookRepository is set: " + (bookRepository != null));
    }
}
