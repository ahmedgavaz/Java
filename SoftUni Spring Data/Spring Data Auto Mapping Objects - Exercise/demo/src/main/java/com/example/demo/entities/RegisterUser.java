package com.example.demo.entities;

import java.util.regex.Pattern;

import static com.example.demo.constants.Messages.*;

public class RegisterUser {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;

    public RegisterUser() {
    }

    public RegisterUser(String email, String password, String confirmPassword, String fullName) {
        setEmail(email);
        setPassword(password);
        setConfirmPassword(confirmPassword);
        setFullName(fullName);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        boolean isValidPassword = Pattern.matches(passwordPattern,password);
        if (!isValidPassword){
            throw new IllegalArgumentException(incorrectUsernamePassword);
        }
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        boolean isValidEmail = Pattern.matches(emailPattern,email);
        if (!isValidEmail){
            throw new IllegalArgumentException(invalidEmail);
        }
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        if (!confirmPassword.equals(this.password)){
            throw new IllegalArgumentException(incorrectUsernamePassword);
        }
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }
}
