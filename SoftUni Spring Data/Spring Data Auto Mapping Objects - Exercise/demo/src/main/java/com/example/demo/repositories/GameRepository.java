package com.example.demo.repositories;

import com.example.demo.entities.GameDTO;
import com.example.demo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends JpaRepository<Game,Long> {
    Optional<Game> findGameByTitle(String title);
    Optional<Game> findGameById(long id);
    @Query("delete from Game as g where g.id= :id")
    @Modifying
    void deleteGameById(long id);

    @Query("Select new com.example.demo.entities.GameDTO(g.title, g.price,g.size,g.trailer, g.imageURL,  g.description, g.releaseDate) from Game g where g.id=:id")
    GameDTO findGameByIdAndReturnDTO(long id);
}
