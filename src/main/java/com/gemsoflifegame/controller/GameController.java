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

    @GetMapping("/start")
    public String startGame(Model model) {
        Game game = new Game();
        game.setSecretCombination(gameService.generateRandomCombination());
        game.setAttemptsRemaining(10); // default attempts
        gameRepository.save(game);
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping("/guess")
    public String makeGuess(@RequestParam Long gameId, @RequestParam List<Integer> guess, Model model) {
        if (guess == null || guess.isEmpty()) {
            model.addAttribute("error", "Guess cannot be empty.");
            return "game";
        }

        Game game = gameRepository.findById(gameId).orElseThrow(() -> new IllegalArgumentException("Invalid game ID"));

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
            model.addAttribute("gameOver", true);
        }

        model.addAttribute("game", game);
        return "game";
    }

    @GetMapping("/history")
    public String viewGameHistory(Model model) {
        List<Game> gameHistory = gameRepository.findByAttemptsRemaining(0);
        model.addAttribute("gameHistory", gameHistory);
        return "gameHistory";
    }
}
