package com.bookstore.mapper;

import org.modelmapper.ModelMapper;

import com.bookstore.Book;
import com.bookstore.dto.BookDTO;


public class BookMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static BookDTO toDTO(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public static Book toEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }
}
