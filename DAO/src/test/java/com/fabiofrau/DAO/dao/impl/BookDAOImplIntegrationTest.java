package com.fabiofrau.DAO.dao.impl;

import com.fabiofrau.DAO.TestDataUtil;
import com.fabiofrau.DAO.dao.AuthorDAO;
import com.fabiofrau.DAO.domain.Author;
import com.fabiofrau.DAO.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class BookDAOImplIntegrationTest {

    private AuthorDAO authorDAO;
    private BookDAOImpl underTest;

    @Autowired
    public BookDAOImplIntegrationTest(BookDAOImpl underTest, AuthorDAO authorDAO) {
        this.underTest = underTest;
        this.authorDAO = authorDAO;
    }

    @Test
    public void testThatBookCanBeCreatedAndRecalled() {
        Author author = TestDataUtil.createTestAuthorA();
        authorDAO.create(author);
        Book book = TestDataUtil.createTestBook();
        book.setAuthorId(author.getId());
        underTest.create(book);
        Optional<Book> result = underTest.find(book.getIsbn());
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(book);


    }
}
