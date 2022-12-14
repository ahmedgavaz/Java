package com.example.demo.services.author;

import com.example.demo.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;

public interface AuthorService {
    void seedAuthor(List<Author> authors);
    boolean isDatabaseSeeded();
    Author getRandomAuthor();

    List<Author> findDistinctByBooksBefore(LocalDate date);

    List<Author> findAllOrderByBooks();

}
