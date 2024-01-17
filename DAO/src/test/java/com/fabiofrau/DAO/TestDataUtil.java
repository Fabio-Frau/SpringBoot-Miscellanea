package com.fabiofrau.DAO;

import com.fabiofrau.DAO.domain.Author;
import com.fabiofrau.DAO.domain.Book;

public final class TestDataUtil {

    private TestDataUtil () {

    }

    public static Author createTestAuthorA() {
        return Author.builder()
                .id(1L)
                .name("Fabio Frau")
                .age(32)
                .build();
    }

    public static Author createTestAuthorB() {
        return Author.builder()
                .id(2L)
                .name("Donald Duck")
                .age(100)
                .build();
    }

    public static Author createTestAuthorC() {
        return Author.builder()
                .id(3L)
                .name("Mickey Mouse")
                .age(57)
                .build();
    }

    public static Book createTestBookA() {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookB() {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .authorId(1L)
                .build();
    }

    public static Book createTestBookC() {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .authorId(1L)
                .build();
    }
}
