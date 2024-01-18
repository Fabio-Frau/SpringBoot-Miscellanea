package com.fabiofrau.JPAHibernate;

import com.fabiofrau.JPAHibernate.domain.Author;
import com.fabiofrau.JPAHibernate.domain.Book;

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

    public static Book createTestBookA(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-0")
                .title("The Shadow in the Attic")
                .author(author)
                .build();
    }

    public static Book createTestBookB(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-1")
                .title("Beyond the Horizon")
                .author(author)
                .build();
    }

    public static Book createTestBookC(final Author author) {
        return Book.builder()
                .isbn("978-1-2345-6789-2")
                .title("The Last Ember")
                .author(author)
                .build();
    }
}
