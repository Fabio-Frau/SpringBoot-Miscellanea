package com.fabiofrau.DAO.dao.impl;

import com.fabiofrau.DAO.TestDataUtil;
import com.fabiofrau.DAO.domain.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDAOImplTests {

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private BookDAOImpl underTest;

    @Test
    public void testThatCreateBookGeneratesCorrectSql() {

        Book book = TestDataUtil.createTestBookA();

        underTest.create(book);

        verify(jdbcTemplate).update(
                eq("INSERT INTO books (isbn, title, author_id) VALUES(?,?,?)"),
                eq("978-1-2345-6789-0"),
                eq("The Shadow in the Attic"),
                eq(1L)
        );
    }

    @Test
    public void testThatFindOneBookGeneratesTheCorrectSql() {

        underTest.findOne("978-1-2345-6789-0");

        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books WHERE isbn = ? LIMIT 1"),
                ArgumentMatchers.<BookDAOImpl.BookRowMapper>any(),
                eq("978-1-2345-6789-0")
        );
    }

    @Test
    public void testThatFindGeneratesCorrectSql() {
        underTest.find();
        verify(jdbcTemplate).query(
                eq("SELECT isbn, title, author_id FROM books"),
                ArgumentMatchers.<BookDAOImpl.BookRowMapper>any());
    }

    @Test
    public void testThatUpdateGeneratesTheCorrectSql() {
        Book book = TestDataUtil.createTestBookA();
        underTest.update("978-1-2345-6789-0", book);
        verify(jdbcTemplate).update(
                "UPDATE books SET isbn = ?, title = ?, author_id = ? WHERE isbn = ?",
                "978-1-2345-6789-0", "The Shadow in the Attic", 1L, "978-1-2345-6789-0"
        );
    }

    @Test
    public void testThatDeleteGeneratesCorrectSql() {
        underTest.delete("978-1-2345-6789-0");
        verify(jdbcTemplate).update(
                "DELETE FROM books WHERE isbn = ?",
                "978-1-2345-6789-0"
        );
    }

}
