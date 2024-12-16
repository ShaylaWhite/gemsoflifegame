package com.gemsoflifegame.controller;

import com.gemsoflifegame.model.Game;
import com.gemsoflifegame.model.Guess;
import com.gemsoflifegame.service.GameService;
import com.gemsoflifegame.repository.GameRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;
    private final GameRepository gameRepository;

    public GameController(GameService gameService, GameRepository gameRepository) {
        this.gameService = gameService;
        this.gameRepository = gameRepository;
    }

    // Start the game and return the Thymeleaf template
    @GetMapping("/start")
    public String startGame(Model model) {
        try {
            Game game = new Game();
            game.setSecretCombination(gameService.generateRandomCombination());
            game.setAttemptsRemaining(10); // default attempts
            gameRepository.save(game);
            model.addAttribute("game", game);  // Add the game object to the model
            return "game"; // This corresponds to game.html in the templates directory
        } catch (Exception e) {
            model.addAttribute("error", "Error starting the game: " + e.getMessage());
            return "game"; // You can redirect to a generic error page if needed
        }
    }

    // Handle the guess submission and provide feedback
    @PostMapping("/guess")
    public String makeGuess(@RequestParam(required = true) Long gameId, @RequestParam List<Integer> guess, Model model) {
        if (guess == null || guess.isEmpty()) {
            model.addAttribute("error", "Guess cannot be empty.");
            return "game"; // This will render the game view again
        }

        // Debugging: Print the guess to verify it's being received correctly
        System.out.println("Received guess: " + guess);

        // Retrieve game based on the provided gameId
        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Invalid game ID"));

        // Check the guess and update the game state
        String feedback = gameService.checkGuess(guess, game.getSecretCombination());
        game.getGuesses().add(new Guess(guess, feedback));
        game.setAttemptsRemaining(game.getAttemptsRemaining() - 1);

        try {
            gameRepository.save(game);
        } catch (Exception e) {
            model.addAttribute("error", "Error saving game: " + e.getMessage());
            return "game";
        }

        if (game.getAttemptsRemaining() <= 0 || feedback.contains("4 correct position(s)")) {
            model.addAttribute("gameOver", true);  // End game condition
        }

        model.addAttribute("game", game); // Add the updated game object to the model
        return "game";  // Thymeleaf will render the "game.html" template
    }


    // View game history
    @GetMapping("/history")
    public String viewGameHistory(Model model) {
        List<Game> gameHistory = gameRepository.findByAttemptsRemaining(0);
        model.addAttribute("gameHistory", gameHistory);
        return "gameHistory"; // This would render gameHistory.html if you're using Thymeleaf
    }
}

