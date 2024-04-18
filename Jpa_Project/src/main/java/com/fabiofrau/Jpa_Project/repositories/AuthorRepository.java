package com.fabiofrau.Jpa_Project.repositories;

import com.fabiofrau.Jpa_Project.models.Author;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer>,
        JpaSpecificationExecutor<Author>
{

    List<Author> findAllByFirstName(String fn);

    List<Author> findAllByFirstNameIgnoreCase(String fn);

    List<Author> findAllByFirstNameContainingIgnoreCase(String fn);

    List<Author> findAllByFirstNameStartsWithIgnoreCase(String fn);

    List<Author> findAllByFirstNameEndsWithIgnoreCase(String fn);

    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    int updateAuthor(int age, int id);

    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);

    List<Author> findByNamedQuery(@Param("age") int age);

}
