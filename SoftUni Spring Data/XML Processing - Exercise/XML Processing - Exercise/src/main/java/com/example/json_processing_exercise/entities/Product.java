package com.example.json_processing_exercise.entities;

import com.example.json_processing_exercise.entities.dto.ProductInRangeDTO;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static com.example.json_processing_exercise.Constants.Messages.nameError;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private User buyer;
    @ManyToOne
    @Fetch(FetchMode.JOIN)
    private User seller;
    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<Category> categories;

    public Product() {
        categories=new HashSet<>();
    }

    public Product(long id, String name, BigDecimal price, User buyer, User seller, Set<Category> categories) {
        setId(id);
        setName(name);
        setPrice(price);
        setBuyer(buyer);
        setSeller(seller);
        setCategories(categories);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length()<3){
            throw new IllegalArgumentException(nameError);
        }
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
    public ProductInRangeDTO toProductQuery1DTO(){
        return new ProductInRangeDTO(getName(),getPrice(),getSeller().getFirstName()+" " +getSeller().getLastName());
    }
}
