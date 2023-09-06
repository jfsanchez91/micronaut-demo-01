package com.example;

import io.micronaut.http.annotation.Controller;
import java.util.Collection;
import lombok.RequiredArgsConstructor;

@Controller(BookApi.ROOT_PATH)
@RequiredArgsConstructor
class BookApiImpl implements BookApi {

  private final BookService service;

  @Override
  public Collection<BookDto> listBooks() {
    return service.findAll();
  }

  @Override
  public BookDto createBook(CreateBookDto book) {
    return service.create(book);
  }
}
