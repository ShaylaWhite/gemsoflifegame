package com.gemsoflifegame.model;

import java.util.List;

public class Guess {
    private List<Integer> guess; // The guess made by the player
    private String feedback; // Feedback after making the guess

    // Constructor to initialize a guess with the player's guess and the feedback
    public Guess(List<Integer> guess, String feedback) {
        this.guess = guess;
        this.feedback = feedback;
    }

    // Getter and Setter for guess
    public List<Integer> getGuess() {
        return guess;
    }

    public void setGuess(List<Integer> guess) {
        this.guess = guess;
    }

    // Getter and Setter for feedback
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
