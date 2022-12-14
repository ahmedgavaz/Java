package com.example.demo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.example.demo.constants.Messages.*;
import static com.example.demo.constants.Messages.incorrectGameDescription;

@Entity
@Table
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true)
    private String title;
    @Column
    private String trailer;
    @Column
    private String imageURL;
    @Column(nullable = false)
    private Float size;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private LocalDate releaseDate;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<User> users;

    @ManyToMany
    private Set<Orders> orders;

    public Game() {
        users = new HashSet<>();
        orders = new HashSet<>();
    }

    public Game(String title, String trailer, String imageURL, Float size, BigDecimal price, String description, LocalDate releaseDate) {
        this();
        setTitle(title);
        setTrailer(trailer);
        setImageURL(imageURL);
        setSize(size);
        setPrice(price);
        setDescription(description);
        setReleaseDate(releaseDate);
    }

    public Set<User> getUsers() {
        return users;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.length()<3 || title.length()>100 || title.charAt(0)<'A' || title.charAt(0)>'Z'){
            throw new IllegalArgumentException(incorrectGameTitle);
        }
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        if (trailer.length()!=11){
            throw new IllegalArgumentException(wrongTrailerLength);
        }
        this.trailer = trailer;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        if (!imageURL.startsWith("http://") && !imageURL.startsWith("https://")){
            throw new IllegalArgumentException(incorrectImageURL);
        }
        this.imageURL = imageURL;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        if (size<=0){
            throw new IllegalArgumentException(incorrectGameSize);
        }
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.doubleValue()<=0){
            throw new IllegalArgumentException(incorrectGamePrice);
        }
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.length()<20){
            throw new IllegalArgumentException(incorrectGameDescription);
        }
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Price: " + price + "\n" +
                "Description: " + description + "\n" +
                "ReleaseDate: " + releaseDate;
    }
}
