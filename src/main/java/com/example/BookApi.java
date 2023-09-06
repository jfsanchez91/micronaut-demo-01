package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import java.util.Collection;

@Produces(MediaType.APPLICATION_JSON)
interface BookApi {

  String ROOT_PATH = "/api/book";

  @Get
  Collection<BookDto> listBooks();

  @Post
  @Consumes(MediaType.APPLICATION_JSON)
  BookDto createBook(@Body CreateBookDto book);
}
