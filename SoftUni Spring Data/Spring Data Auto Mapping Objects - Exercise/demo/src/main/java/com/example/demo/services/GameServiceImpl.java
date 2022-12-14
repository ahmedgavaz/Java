package com.example.demo.services;

import com.example.demo.entities.GameDTO;
import com.example.demo.entities.Game;
import com.example.demo.repositories.GameRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static com.example.demo.constants.Messages.*;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserServiceImpl userService) {
        this.gameRepository = gameRepository;
        this.userService = userService;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Optional<Game> findGameByTitle(String title) {
        return this.gameRepository.findGameByTitle(title);
    }

    @Override
    public void addGame(String[] args) {
        if (!userService.isUserLogged()) {
            throw new IllegalArgumentException(userIsNotLoggedIn);
        }
        if (!userService.getUser().getAdministrator()) {
            throw new IllegalArgumentException(userIsNotAdmin);
        }
        if (this.gameRepository.findGameByTitle(args[1]).isPresent()) {
            throw new IllegalArgumentException(gameIsInTheStore);
        }
        int[] date = Arrays.stream(args[7].split("-")).mapToInt(Integer::parseInt).toArray();
        GameDTO gameDTO = new GameDTO(args[1], BigDecimal.valueOf(Double.parseDouble(args[2])), Float.parseFloat(args[3]), args[4], args[5], args[6], LocalDate.of(date[2], date[1], date[0]));
        Game game = modelMapper.map(gameDTO, Game.class);
        System.out.println(addedGame + game.getTitle());
        this.gameRepository.save(game);
    }

    @Override
    @Transactional
    public void deleteGame(long id) {
        if (!userService.isUserLogged()) {
            throw new IllegalArgumentException(userIsNotLoggedIn);
        }
        if (!userService.getUser().getAdministrator()) {
            throw new IllegalArgumentException(userIsNotAdmin);
        }
        if (findGameById(id).isEmpty()) {
            throw new IllegalArgumentException(notFoundGame);
        }
        Game game = findGameById(id).orElseThrow();
        System.out.println(deleteGame + game.getTitle());
        this.gameRepository.deleteGameById(id);
    }

    @Override
    public Optional<Game> findGameById(long id) {
        return this.gameRepository.findGameById(id);
    }

    @Override
    public GameDTO findGameByIdAndReturnDTO(long id) {
        return this.gameRepository.findGameByIdAndReturnDTO(id);
    }

    @Override
    public void allGames() {
        List<Game> list = this.gameRepository.findAll();
        if (list.size() == 0) {
            throw new IllegalArgumentException(emptyStore);
        } else {
            list.forEach(e -> System.out.println(e.getTitle() + " " + e.getPrice()));
        }
    }

    @Override
    public void detailedView(String name) {
        if (this.gameRepository.findGameByTitle(name).isEmpty()) {
            throw new IllegalArgumentException(noGameWithName);
        }
        Game game = findGameByTitle(name).orElseThrow();
        System.out.println(game);
    }

    @Override
    public void purchase(String name) {
        if (this.gameRepository.findGameByTitle(name).isEmpty()) {
            throw new IllegalArgumentException(noGameWithName);
        }
        Game game = findGameByTitle(name).orElseThrow();
        userService.addGame(game);
        game.getUsers().add(userService.getUser());
        gameRepository.save(game);
        System.out.println(successfullyPurchased);
    }

    @Override
    public void ownedGames() {
        userService.getUser().getGames().forEach(e -> System.out.println(e.getTitle()));
    }

    public void editGame(String[] args) {
        if (!userService.isUserLogged()) {
            throw new IllegalArgumentException(userIsNotLoggedIn);
        }
        if (!userService.getUser().getAdministrator()) {
            throw new IllegalArgumentException(userIsNotAdmin);
        }
        if (findGameById(Long.parseLong(args[1])).isEmpty()) {
            throw new IllegalArgumentException(notFoundGame);
        }
        if (args.length <= 2) {
            throw new IllegalArgumentException(noFieldForEditing);
        }
        Game game = findGameById(Long.parseLong(args[1])).orElseThrow();
        for (int i = 2; i < args.length; i++) {
            String[] arguments = args[i].split("=");
            switch (arguments[0]) {
                case "title":
                    game.setTitle(arguments[1]);
                    break;
                case "price":
                    game.setPrice(BigDecimal.valueOf(Double.parseDouble(arguments[1])));
                    break;
                case "size":
                    game.setSize(Float.parseFloat(arguments[1]));
                    break;
                case "trailer":
                    game.setTrailer(arguments[1]);
                    break;
                case "thumbnail URL":
                    game.setImageURL(arguments[1]);
                    break;
                case "description":
                    game.setDescription(arguments[1]);
                    break;
                default:
                    System.out.println(noFoundCommand);
            }
        }
        this.gameRepository.save(game);
        System.out.println(editedGame + game.getTitle());
    }
}
