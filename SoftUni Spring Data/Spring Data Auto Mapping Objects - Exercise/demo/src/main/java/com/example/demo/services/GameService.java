package com.example.demo.services;

import com.example.demo.entities.GameDTO;
import com.example.demo.entities.Game;

import java.util.Optional;

public interface GameService {
    Optional<Game> findGameByTitle(String title);
    void addGame(String[] args);

    void deleteGame(long id);

    Optional<Game> findGameById(long id);
    GameDTO findGameByIdAndReturnDTO(long id);

    void allGames();

    void detailedView(String game);

    void purchase(String name);

    void ownedGames();

}
