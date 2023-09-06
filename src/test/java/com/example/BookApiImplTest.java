package com.example;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest
class BookApiImplTest {

  @Client(BookApi.ROOT_PATH)
  interface BookApiClient extends BookApi {

  }

  @Inject
  BookApiClient client;

  @BeforeEach
  void setup(BookRepository repository) {
    repository.deleteAll();
  }

  @Test
  void listBooks() {
    final var books = List.of(
        new CreateBookDto("Hello World"),
        new CreateBookDto("Hola Mundo"),
        new CreateBookDto("Hallo Welt")

    );
    books.forEach(it -> client.createBook(it));
    Assertions.assertEquals(books.size(), client.listBooks().size());
  }

  @Test
  void listBooks2() {
    final var books = List.of(
        new CreateBookDto("Hello World"),
        new CreateBookDto("Hola Mundo"),
        new CreateBookDto("Hallo Welt")

    );
    books.forEach(it -> client.createBook(it));
    Assertions.assertEquals(books.size(), client.listBooks().size());
  }
}
