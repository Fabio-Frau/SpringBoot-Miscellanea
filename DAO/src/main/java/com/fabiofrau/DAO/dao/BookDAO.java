package com.fabiofrau.DAO.dao;

import com.fabiofrau.DAO.domain.Book;

import java.util.Optional;

public interface BookDAO {

    void create(Book book);

    Optional<Book> find(String isbn);
}
