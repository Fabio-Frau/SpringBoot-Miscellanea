package com.fabiofrau.DAO.dao;

import com.fabiofrau.DAO.domain.Author;

import java.util.Optional;

public interface AuthorDAO {
    void create(Author author);

    Optional<Author> findOne(long l);


}
