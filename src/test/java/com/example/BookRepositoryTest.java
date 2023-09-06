package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class BookRepositoryTest {

  @Inject
  BookRepository repository;

  @Test
  void test_it_saves_books() {
    final var book = Book.of("random title");
    final var savedBook = repository.save(book);
    Assertions.assertNotNull(savedBook);
    Assertions.assertEquals(book.title(), savedBook.title());
  }
}
