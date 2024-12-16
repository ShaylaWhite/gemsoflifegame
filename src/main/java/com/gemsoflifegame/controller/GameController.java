package com.gemsoflifegame.controller;

import com.gemsoflifegame.model.Game;
import com.gemsoflifegame.model.Guess;
import com.gemsoflifegame.service.GameService;
import com.gemsoflifegame.repository.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final GameRepository gameRepository;

    public GameController(GameService gameService, GameRepository gameRepository) {
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }

    @GetMapping("/start")
    public String startGame(Model model) {
        // Initialize a new game and set the secret combination here
        Game game = new Game();
        gameRepository.save(game);  // Save the game to the repository

        model.addAttribute("gameId", game.getId());  // Pass the gameId to the view
        model.addAttribute("attemptsRemaining", game.getAttemptsRemaining());
        model.addAttribute("lifeLesson", game.getLifeLesson());

        return "game";  // Return the game page
    }

    @PostMapping("/guess")
    @ResponseBody
    public ResponseEntity<Game> makeGuess(@RequestParam Long gameId, @RequestParam String guess) {
        if (guess == null || guess.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Convert the comma-separated guess string into a list of integers
        List<Integer> guessList = Arrays.stream(guess.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game ID"));

        String feedback = gameService.checkGuess(guessList, game.getSecretCombination());
        game.getGuesses().add(new Guess(guessList, feedback));
        game.setAttemptsRemaining(game.getAttemptsRemaining() - 1);

        try {
            gameRepository.save(game);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }

        if (game.getAttemptsRemaining() <= 0 || feedback.contains("4 correct position(s)")) {
            game.setGameOver(true);  // Mark game as over
        }

        // Return updated game state as JSON
        return ResponseEntity.ok(game);
    }


    @GetMapping("/history")
    public String viewGameHistory(Model model) {
        List<Game> gameHistory = gameRepository.findByAttemptsRemaining(0);
        model.addAttribute("gameHistory", gameHistory);
        return "gameHistory";
    }
}

