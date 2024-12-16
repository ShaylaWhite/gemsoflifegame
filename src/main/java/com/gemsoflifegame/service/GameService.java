package com.gemsoflifegame.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {
    private static final String RANDOM_API_URL = "https://www.random.org/integers/?num=4&min=0&max=7&col=1&base=10&format=plain";

    private RestTemplate restTemplate;

    public GameService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Generate a random 4-digit combination
    public List<Integer> generateRandomCombination() {
        String response = restTemplate.getForObject(RANDOM_API_URL, String.class);
        return Arrays.stream(response.split("\n"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    // Check the player's guess
    public String checkGuess(List<Integer> guess, List<Integer> secretCombination) {
        int correctDigits = 0;
        int correctPositions = 0;

        for (int i = 0; i < guess.size(); i++) {
            if (secretCombination.contains(guess.get(i))) {
                correctDigits++;
                if (secretCombination.get(i).equals(guess.get(i))) {
                    correctPositions++;
                }
            }
        }

        return correctPositions + " correct position(s), " + correctDigits + " correct number(s)";
    }
    // Helper method to check if a number exists in the secret combination (but not at the same position)
    private boolean containsNumber(int[] secretCombination, int number) {
        for (int i : secretCombination) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }
}

