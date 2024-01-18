package com.fabiofrau.JPAHibernate.repositories;

import com.fabiofrau.JPAHibernate.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
}
