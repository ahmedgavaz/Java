package com.example.demo.services.seed;

import com.example.demo.constants.Resources;
import com.example.demo.domain.entities.Author;
import com.example.demo.domain.entities.Book;
import com.example.demo.domain.entities.Category;
import com.example.demo.domain.enums.AgeRestriction;
import com.example.demo.domain.enums.EditionType;
import com.example.demo.services.author.AuthorService;
import com.example.demo.services.book.BookService;
import com.example.demo.services.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SeedServiceImpl implements SeedService {
    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;

    @Autowired
    public SeedServiceImpl(AuthorService authorService, BookService bookService, CategoryService categoryService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.bookService = bookService;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (!authorService.isDatabaseSeeded()) {
            this.authorService.seedAuthor(Files.readAllLines(Path.of(Resources.FILES_FOLDER + Resources.AUTHOR_FILE_NAME)).stream().
                    filter(e -> !e.isBlank()).map(a -> Author.builder().firstName(a.split(" ")[0]).lastName(a.split(" ")[1]).build()).
                    collect(Collectors.toList()));
        }
    }

    @Override
    public void seedBooks() throws IOException {
        if (!this.bookService.isDatabaseSeeded()){
            this.bookService.seedBook(Files.readAllLines(Path.of(Resources.FILES_FOLDER+Resources.BOOK_FILE_NAME)).stream().
                    filter(e->!e.isBlank()).map(row->{
                        String[] data = row.split("\\s+");
                        return Book.builder().title(Arrays.stream(data).skip(5).collect(Collectors.joining(" "))).editionType(EditionType.values()[Integer.parseInt(data[0])])
                                .price(new BigDecimal(data[3]))
                                .releaseDate(LocalDate.parse(data[1], DateTimeFormatter.ofPattern("d/M/yyyy")))
                                .ageRestriction(AgeRestriction.values()[Integer.parseInt(data[4])])
                                .author(this.authorService.getRandomAuthor())
                                .categories(this.categoryService.getRandomCategory())
                                .copies(Integer.parseInt(data[2]))
                                .build();

                    }).collect(Collectors.toList()));
        }
    }

    @Override
    public void seedCategories() throws IOException {
        if (!this.categoryService.isDatabaseSeeded()){
            this.categoryService.seedCategory(Files.readAllLines(Path.of(Resources.FILES_FOLDER+Resources.CATEGORY_FILE_NAME)).stream().
                    filter(e->!e.isBlank()).map(name-> Category.builder().name(name).build()).collect(Collectors.toList()));
        }
    }

}
