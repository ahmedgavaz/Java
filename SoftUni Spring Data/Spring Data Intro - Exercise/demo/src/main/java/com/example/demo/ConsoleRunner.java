package com.example.demo;

import com.example.demo.domain.entities.Book;
import com.example.demo.services.author.AuthorService;
import com.example.demo.services.book.BookService;
import com.example.demo.services.seed.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final LocalDate BOOK_YEAR_AFTER = LocalDate.of(2000, 1, 1);
    private final LocalDate BOOK_YEAR_BEFORE = LocalDate.of(1990, 1, 1);

    private final SeedService seedService;
    private final BookService bookService;
    private AuthorService authorService;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookService bookService, AuthorService authorService) {
        this.seedService = seedService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.seedService.seedAll();
        this.getAllBooksAfterAGivenYear(BOOK_YEAR_AFTER);
        this.getAllAuthorsWithBooksReleaseDateBefore();
        this.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc();
        this.getAllOrderByBooks();
        this.findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc();

    }

    private void getAllBooksAfterAGivenYear(LocalDate BOOK_YEAR_AFTER){
        List< Book> list = this.bookService.findAllByReleaseDateAfter(BOOK_YEAR_AFTER);
        for (Book book:list) {
            System.out.println(book.getTitle());
        }
        System.out.println();
    }
    private void getAllAuthorsWithBooksReleaseDateBefore() {
        this.authorService
                .findDistinctByBooksBefore(BOOK_YEAR_BEFORE)
                .forEach(author -> System.out.println(author.getFirstName() + " " + author.getLastName()));
    }

    private void getAllOrderByBooks() {
        this.authorService.findAllOrderByBooks()
                .forEach(author -> System.out.println(author.toStringWithCount()));
    }

    private void findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc() {
        this.bookService
                .findAllByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc("George", "Powell")
                .forEach(book -> System.out.println(book.getTitle() + " "
                        + book.getReleaseDate() + " "
                        + book.getCopies()));
    }
}