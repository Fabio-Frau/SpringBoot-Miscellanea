package com.fabiofrau.RestAPi.services.impl;

import com.fabiofrau.RestAPi.domain.entities.BookEntity;
import com.fabiofrau.RestAPi.repositories.BookRepository;
import com.fabiofrau.RestAPi.services.BookService;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookEntity createBook(String isbn, BookEntity book) {
        book.setIsbn(isbn);
        return bookRepository.save(book);
    }
}
