package com.fabiofrau.RestAPi.services;

import com.fabiofrau.RestAPi.domain.entities.BookEntity;

import java.awt.print.Book;

public interface BookService {

    BookEntity createBook(String isbn, BookEntity book);

}
