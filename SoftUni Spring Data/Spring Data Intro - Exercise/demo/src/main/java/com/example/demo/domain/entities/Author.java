package com.example.demo.domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(nullable = false,name = "last_name")
    private String lastName;

    @OneToMany(targetEntity = Book.class,mappedBy = "author",fetch = FetchType.EAGER)
    private Set<Book> books;

    public Author(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toStringWithCount() {
        return String.format("%s %s %d", firstName, lastName, books.size());
    }
}
