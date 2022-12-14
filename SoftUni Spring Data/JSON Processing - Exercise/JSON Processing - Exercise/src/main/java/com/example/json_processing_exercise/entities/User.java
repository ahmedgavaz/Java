package com.example.json_processing_exercise.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static com.example.json_processing_exercise.Constants.Messages.nameError;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column
    private Integer age;
    @ManyToMany
    @Fetch(FetchMode.JOIN)
    private Set<User> friends;
    @OneToMany(targetEntity = Product.class,mappedBy = "seller")
    @Fetch(FetchMode.JOIN)
    private Set<Product> sellingProducts;
    @OneToMany(targetEntity = Product.class,mappedBy = "buyer")
    @Fetch(FetchMode.JOIN)
    private Set<Product> boughtProducts;

    public User() {
    }

    public User(long id, String firstName, String lastName, Integer age) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
    }

    public User(long id, String firstName, String lastName, Integer age, Set<User> friends, Set<Product> sellingProducts, Set<Product> boughtProducts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.friends = friends;
        this.sellingProducts = sellingProducts;
        this.boughtProducts = boughtProducts;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Product> getSellingProducts() {
        return sellingProducts;
    }

    public void setSellingProducts(Set<Product> sellingProducts) {
        this.sellingProducts = sellingProducts;
    }

    public Set<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public void setBoughtProducts(Set<Product> boughtProducts) {
        this.boughtProducts = boughtProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length()<3){
            throw new IllegalArgumentException(nameError);
        }
        this.lastName=lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(id,user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }
}
