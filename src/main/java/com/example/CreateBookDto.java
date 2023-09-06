package com.example;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
record CreateBookDto(
    String title
) {
}
