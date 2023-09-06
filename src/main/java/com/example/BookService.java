package com.example;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Singleton;
import jakarta.transaction.Transactional;
import java.util.Collection;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
@RequiredArgsConstructor
class BookService {

  private final BookRepository repository;

  public Collection<BookDto> findAll() {
    final var books = repository.findAll();
    log.info("Books {}", books);
    return books.stream()
        .map(BookDto::from)
        .collect(Collectors.toSet());
  }

  @Transactional
  public BookDto create(CreateBookDto book) {
    return BookDto.from(repository.save(Book.of(book.title())));
  }
}
