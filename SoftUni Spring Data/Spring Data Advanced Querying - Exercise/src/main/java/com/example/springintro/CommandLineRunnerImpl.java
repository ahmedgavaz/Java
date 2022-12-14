package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.BookInformation;
import com.example.springintro.model.entity.EditionType;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.spi.LocaleNameProvider;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private Scanner scanner;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
       // seedData();

        //printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
        //   printAllAuthorsAndNumberOfTheirBooks();
        // printAllBooksByAuthorNameOrderByReleaseDate("George", "Powell");

        /*1.Books Titles by Age Restriction
        String ageRestrictionInput = scanner.nextLine();
        AgeRestriction ageRestriction = AgeRestriction.valueOf(ageRestrictionInput.toUpperCase());
        printAllBooksByAgeRestrictionIs(ageRestriction);

        2.Golden Books
        printAllBooksFromGoldenEditionWithLessThan5000Copies();

        3.Books by Price
        printAllBooksWithPriceLessThan5AndGreaterThan40();

        4.Not Released Books
        String year = scanner.nextLine();
        printAllBooksNotInYear(year);

        5.Books Released Before Date
        String date = scanner.nextLine();
        printAllBooksWithReleaseDateBefore(date);

        6.Authors Search
        String str = scanner.nextLine();
        printAllAuthorWhoseFirstNameEndsWith(str);

        7.Books Search
        String str = scanner.nextLine();
        printAllBooksContainsTheString(str);

        8.Book Titles Search
        String str = scanner.nextLine();
        printAllBooksWhoseAuthorsLastNameStartsWith(str);

        9.Count Books
        int length = Integer.parseInt(scanner.nextLine());
        printCountOfBooksWithTitleLongerThan(length);

        10.Total Book Copies
        printAllAuthorsByCopies();*/

        String title = scanner.nextLine();
        printBookByTitle(title);
    }

    private void printBookByTitle(String title){
        BookInformation bookInformation = this.bookService.findBookByTitle(title);
        System.out.println(bookInformation);
    }

    private void printAllAuthorsByCopies(){
        this.authorService.findByAuthorsCopies().
                forEach(e-> System.out.printf("%s %s - %s\n",e[0],e[1],e[2]));
    }

    private void printCountOfBooksWithTitleLongerThan(int length){
        int count = this.bookService.findAllByCountOfLettersGreaterThan(length);
        System.out.println("There are "+count+" books with longer title than 12 symbols");
    }

    private void printAllBooksWhoseAuthorsLastNameStartsWith(String str){
        this.bookService.findAllByAuthorLastNameStartingWith(str).
                forEach(e-> System.out.printf("%s (%s %s)\n",e.getTitle(),e.getAuthor().getFirstName(),e.getAuthor().getLastName()));
    }

    private void printAllBooksContainsTheString(String str) {
        this.bookService.findAllByTitleContainingIgnoreCase(str).forEach(e -> System.out.println(e.getTitle()));
    }

    private void printAllAuthorWhoseFirstNameEndsWith(String str) {
        this.authorService.findAllByFirstNameEndingWith(str).forEach(e -> System.out.println(e.getFirstName() + " " + e.getLastName()));
    }

    private void printAllBooksWithReleaseDateBefore(String date) {
        int[] parameters = Arrays.stream(date.split("-")).mapToInt(e -> Integer.parseInt(e)).toArray();
        LocalDate dateForComparing = LocalDate.of(parameters[2], parameters[1], parameters[0]);
        this.bookService.findAllByReleaseDateBefore(dateForComparing).
                forEach(e -> System.out.printf("%s %s %.2f\n", e.getTitle(), e.getEditionType(), e.getPrice()));
    }

    private void printAllBooksNotInYear(String year) {
        LocalDate dateBefore = LocalDate.of(Integer.parseInt(year), 1, 1);
        LocalDate dateAfter = LocalDate.of(Integer.parseInt(year), 12, 31);
        this.bookService.findAllByReleaseDateBeforeOrReleaseDateAfter(dateBefore, dateAfter).forEach(e -> System.out.println(e.getTitle()));

    }

    private void printAllBooksWithPriceLessThan5AndGreaterThan40() {
        this.bookService.findAllByPriceLessThanOrPriceGreaterThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(e -> System.out.printf("%s - $%.2f\n", e.getTitle(), e.getPrice()));
    }

    private void printAllBooksFromGoldenEditionWithLessThan5000Copies() {
        this.bookService.findAllByEditionTypeAndCopiesLessThan(EditionType.GOLD, 5000).stream()
                .forEach(e -> System.out.println(e.getTitle()));
    }

    private void printAllBooksByAgeRestrictionIs(AgeRestriction ageRestriction) {
        this.bookService.findAllByAgeRestrictionIs(ageRestriction).forEach(e -> System.out.println(e.getTitle()));
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
