package com.example.demo.constants;

public enum Messages {
    ;
    public static final String emailPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    public static final String invalidEmail = "Incorrect email.";
    public static final String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    public static final String incorrectUsernamePassword = "Incorrect username / password";
    public static final String cannotLogout = "Cannot log out. No user was logged in.";
    public static final String successfulRegistration = " was registered";
    public static final String successfulLogged = "Successfully logged in ";
    public static final String successfulLogout = " successfully logged out";
    public static final String incorrectGameTitle = "Incorrect game title.";
    public static final String wrongTrailerLength = "Trailer length should be exactly 11 symbols.";
    public static final String incorrectImageURL = "The URL of the image is wrong.";
    public static final String incorrectGameSize = "The size is incorrect.";
    public static final String incorrectGamePrice = "The price is incorrect.";
    public static final String incorrectGameDescription = "The description should be at least 20 symbols.";
    public static final String userIsNotLoggedIn = "The user isn't logged in.";
    public static final String gameIsInTheStore = "The game is already in the store.";
    public static final String addedGame = "Added ";
    public static final String notFoundGame = "There isn't game with this id in the store";
    public static final String deleteGame = "Deleted ";
    public static final String loggedInUser = "The user is already logged in";
    public static final String noFieldForEditing = "No field for editing";
    public static final String noFoundCommand = "Not found this command";
    public static final String emptyStore = "The store is empty";
    public static final String noGameWithName = "There isn't game with that name in the store";
    public static final String successfullyPurchased = "The game was purchased";
    public static final String editedGame = "Edited ";
    public static final String userIsNotAdmin = "User is not an admin";
}
