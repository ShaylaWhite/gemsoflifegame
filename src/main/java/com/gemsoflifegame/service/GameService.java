package com.gemsoflifegame.service;

import com.gemsoflifegame.repository.GameRepository;
import com.gemsoflifegame.repository.GuessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private static final String RANDOM_API_URL = "https://example.com/random";

    private final GameRepository gameRepository;
    private final GuessRepository guessRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public GameService(GameRepository gameRepository, GuessRepository guessRepository, RestTemplate restTemplate) {
        this.gameRepository = gameRepository;
        this.guessRepository = guessRepository;
        this.restTemplate = restTemplate;
    }

    public List<Integer> generateRandomCombination() {
        String response = restTemplate.getForObject(RANDOM_API_URL, String.class);
        if (response == null || response.isEmpty()) {
            throw new RuntimeException("Failed to fetch random combination from API.");
        }
        return Arrays.stream(response.split("\n"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public String checkGuess(List<Integer> guess, List<Integer> secretCombination) {
        // Validate inputs
        if (guess == null || guess.isEmpty()) {
            throw new IllegalArgumentException("Guess cannot be null or empty.");
        }
        if (secretCombination == null || secretCombination.isEmpty()) {
            throw new IllegalArgumentException("Secret combination cannot be null or empty.");
        }

        // Check if the sizes match
        if (guess.size() != secretCombination.size()) {
            throw new IllegalArgumentException("Guess and secret combination must have the same number of digits.");
        }

        int correctDigits = 0;
        int correctPositions = 0;

        // Check for correct positions
        for (int i = 0; i < guess.size(); i++) {
            if (secretCombination.get(i).equals(guess.get(i))) {
                correctPositions++;
            }
        }

        // Check for correct digits (not in the correct position)
        for (int i = 0; i < guess.size(); i++) {
            if (!secretCombination.get(i).equals(guess.get(i)) && secretCombination.contains(guess.get(i))) {
                correctDigits++;
            }
        }

        return correctPositions + " correct position(s), " + correctDigits + " correct number(s)";
    }

}
