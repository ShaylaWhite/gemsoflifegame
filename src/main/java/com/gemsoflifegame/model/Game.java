package com.gemsoflifegame.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Integer> secretCombination; // The computer's number combination
    private List<Guess> guesses; // User guesses
    private int attemptsRemaining; // Attempts left
    private String lifeLesson; // Life lesson corresponding to current guess

    public Game() {
        this.attemptsRemaining = 10; // Default number of attempts
        this.guesses = new ArrayList<>();
        this.lifeLesson = "Perseverance"; // initial lesson
    }

    // Getter and Setter for secretCombination
    public List<Integer> getSecretCombination() {
        return secretCombination;
    }

    public void setSecretCombination(List<Integer> secretCombination) {
        this.secretCombination = secretCombination;
    }

    // Getter and Setter for guesses
    public List<Guess> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Guess> guesses) {
        this.guesses = guesses;
    }

    // Getter and Setter for attemptsRemaining
    public int getAttemptsRemaining() {
        return attemptsRemaining;
    }

    public void setAttemptsRemaining(int attemptsRemaining) {
        this.attemptsRemaining = attemptsRemaining;
    }

    // Getter and Setter for lifeLesson
    public String getLifeLesson() {
        return lifeLesson;
    }

    public void setLifeLesson(String lifeLesson) {
        this.lifeLesson = lifeLesson;
    }
}
