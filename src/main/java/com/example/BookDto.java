package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
record BookDto(
    Long id,
    String title
) {

  public static BookDto from(Book book) {
    return new BookDto(book.id(), book.title());
  }
}
