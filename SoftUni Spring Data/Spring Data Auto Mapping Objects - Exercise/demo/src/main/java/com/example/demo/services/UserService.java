package com.example.demo.services;


import com.example.demo.entities.Game;
import com.example.demo.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findByEmailAndPassword(String email, String password);
    void registerUser(String[] args);
    void loginUser(String[] args);
    User findFirstByEmailAndPassword(String email, String password);
    void logoutUser();
    boolean isUserLogged();
    void addGame(Game game);

    void ownedGames();
}
