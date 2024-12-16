import com.gemsoflifegame.model.Game;
import com.gemsoflifegame.service.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/game")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    // Start a new game
    @GetMapping("/start")
    public String startGame(Model model) {
        Game game = new Game();
        game.setSecretCombination(gameService.generateRandomCombination());
        model.addAttribute("game", game);
        return "game"; // return to game.html
    }

    // Handle player's guess
    @PostMapping("/guess")
    public String makeGuess(@ModelAttribute Game game, @RequestParam List<Integer> guess, Model model) {
        String feedback = gameService.checkGuess(guess, game.getSecretCombination());
        game.getGuesses().add(new Guess(guess, feedback));
        game.setAttemptsRemaining(game.getAttemptsRemaining() - 1);

        // Handle when the game is over or a correct guess is made
        if (game.getAttemptsRemaining() <= 0 || feedback.contains("4 correct position(s)")) {
            model.addAttribute("gameOver", true);
        }

        model.addAttribute("game", game);
        return "game"; // update the UI with new state
    }
}
