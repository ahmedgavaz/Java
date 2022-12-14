package com.example.demo;

import com.example.demo.services.GameServiceImpl;
import com.example.demo.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

import static com.example.demo.constants.Commands.*;

@Component
public class ConsoleRunner implements CommandLineRunner {
    private final Scanner scanner = new Scanner(System.in);
    private final UserServiceImpl userService;
    private final GameServiceImpl gameService;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, GameServiceImpl gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        String[] input = scanner.nextLine().split("\\|");
        while (!input[0].equals("close")) {
            try {
                switch (input[0]) {
                    case registerUser:
                        userService.registerUser(input);
                        break;
                    case loginUser:
                        userService.loginUser(input);
                        break;
                    case logout:
                        userService.logoutUser();
                        break;
                    case addGame:
                        gameService.addGame(input);
                        break;
                    case editGame:
                        gameService.editGame(input);
                        break;
                    case deleteGame:
                        gameService.deleteGame(Long.parseLong(input[1]));
                        break;
                    case allGames:
                        gameService.allGames();
                        break;
                    case detailGame:
                        gameService.detailedView(input[1]);
                        break;
                    case ownedGames:
                        gameService.ownedGames();
                        break;
                    case purchased:
                        gameService.purchase(input[1]);
                        break;
                    default:
                        System.out.println(wrongCommand);
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine().split("\\|");
        }
    }
}
