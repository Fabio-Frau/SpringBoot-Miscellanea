package com.fabiofrau.JPAHibernate.repositories;

import com.fabiofrau.JPAHibernate.domain.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

}
