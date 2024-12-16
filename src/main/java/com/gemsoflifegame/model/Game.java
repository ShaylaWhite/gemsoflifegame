package com.gemsoflifegame.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> secretCombination; // The computer's number combination
    private List<Guess> guesses; // User guesses
    private int attemptsRemaining; // Attempts left
    private String lifeLesson; // Life lesson corresponding to current guess

    public Game() {
        this.attemptsRemaining = 10;
        this.guesses = new ArrayList<>();
        this.lifeLesson = "Perseverance"; // initial lesson
    }

    // Add getters and setters
}
