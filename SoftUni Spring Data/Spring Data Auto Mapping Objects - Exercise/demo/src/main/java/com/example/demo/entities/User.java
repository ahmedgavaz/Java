package com.example.demo.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static com.example.demo.constants.Messages.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column
    private Boolean isAdministrator;
    @ManyToMany(targetEntity = Game.class,mappedBy = "users",fetch = FetchType.EAGER)
    private Set<Game> games;
    @OneToMany(targetEntity = Orders.class,mappedBy = "user",fetch = FetchType.EAGER)
    private Set<Orders> orders;

    public User() {
        games = new HashSet<>();
        orders = new HashSet<>();
    }

    public User(String email, String password, String fullName) {
        this();
        this.email = email;
        this.password = password;
        this.fullName = fullName;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Boolean getAdministrator() {
        return isAdministrator;
    }

    public void setAdministrator(Boolean administrator) {
        isAdministrator = administrator;
    }

    public String successfulRegistration(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getFullName())
                .append(successfulRegistration);
        return stringBuilder.toString();
    }
    public String successfulLogin(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(successfulLogged).append(getFullName());
        return stringBuilder.toString();
    }
    public String successfulLogout(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("User ").append(getFullName()).append(successfulLogout);
        return stringBuilder.toString();
    }
}
