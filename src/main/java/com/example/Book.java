package com.example;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

@MappedEntity
record Book(
    @Id
    @GeneratedValue
    Long id,
    String title
) {

  public static Book of(String title) {
    return new Book(null, title);
  }
}
