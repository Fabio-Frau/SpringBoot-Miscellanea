package com.fabiofrau.DAO;

import com.fabiofrau.DAO.domain.Author;
import com.fabiofrau.DAO.domain.Book;

public final class TestDataUtil {

    private TestDataUtil () {

    }

    public static Author createTestAuthor() {
        return Author.builder()
                .id(1L)
                .name("Fabio Frau")
                .age(32)
                .build();
    }

    public static Book createTestBook() {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }
}
