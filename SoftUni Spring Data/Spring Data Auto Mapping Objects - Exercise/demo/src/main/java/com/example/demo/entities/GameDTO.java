package com.example.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import static com.example.demo.constants.Messages.*;

public class GameDTO {

    private String title;

    private String trailer;

    private String imageURL;

    private Float size;

    private BigDecimal price;

    private String description;

    private LocalDate releaseDate;

    public GameDTO() {
    }

    public GameDTO(String title, BigDecimal price, Float size, String trailer, String imageURL, String description, LocalDate releaseDate) {
        setTitle(title);
        setTrailer(trailer);
        setImageURL(imageURL);
        setSize(size);
        setPrice(price);
        setDescription(description);
        setReleaseDate(releaseDate);
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
}
