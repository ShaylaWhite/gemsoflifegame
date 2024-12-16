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
        gameRepository.save(game);  // Save the new game to the database
        model.addAttribute("game", game);
        return "game"; // return to game.html
    }

    @PostMapping("/guess")
    public String makeGuess(@ModelAttribute Game game, @RequestParam List<Integer> guess, Model model) {
        String feedback = gameService.checkGuess(guess, game.getSecretCombination());
        game.getGuesses().add(new Guess(guess, feedback));
        game.setAttemptsRemaining(game.getAttemptsRemaining() - 1);

        // Save updated game state
        gameRepository.save(game);

        // Handle when the game is over or a correct guess is made
        if (game.getAttemptsRemaining() <= 0 || feedback.contains("4 correct position(s)")) {
            model.addAttribute("gameOver", true);
        }

        model.addAttribute("game", game);
        return "game"; // update the UI with new state
    }

    // View game history
    @GetMapping("/history")
    public String viewGameHistory(Model model) {
        List<Game> gameHistory = gameRepository.findByAttemptsRemaining(0); // Get all completed games (attemptsRemaining == 0)
        model.addAttribute("gameHistory", gameHistory);
        return "gameHistory"; // View game history page
    }
}
