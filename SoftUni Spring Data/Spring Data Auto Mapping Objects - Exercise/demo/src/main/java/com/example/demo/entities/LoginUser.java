package com.example.demo.entities;

import javax.persistence.Column;

public class LoginUser {
    private String email;
    private String password;

    public LoginUser() {
    }

    public LoginUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
