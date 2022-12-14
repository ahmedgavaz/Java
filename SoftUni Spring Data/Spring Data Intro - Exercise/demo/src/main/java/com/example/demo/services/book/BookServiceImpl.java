package com.example.demo.services.book;

import com.example.demo.domain.entities.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookServiceImpl implements BookService{
    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void seedBook(List<Book> books) {
        this.bookRepository.saveAll(books);
    }

    @Override
    public boolean isDatabaseSeeded() {
        return this.bookRepository.count()>0;
    }

    @Override
    public List<Book> findAllByReleaseDateAfter(LocalDate localDate) {
        return this.bookRepository.findAllByReleaseDateAfter(localDate).orElseThrow(NoSuchElementException::new);
    }
    @Override
    public List<Book> findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName) {
        return this.bookRepository.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName)
                .orElseThrow(NoSuchElementException::new);
    }
}
