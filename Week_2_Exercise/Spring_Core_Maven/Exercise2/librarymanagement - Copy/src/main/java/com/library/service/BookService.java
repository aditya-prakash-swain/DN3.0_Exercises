package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        System.out.println("BookRepository has been set in BookService.");
    }

    public void someServiceMethod() {
        System.out.println("someServiceMethod in BookService called.");
        // Interact with bookRepository
    }
}

