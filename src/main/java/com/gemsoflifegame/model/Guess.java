package com.gemsoflifegame.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Guess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;  // Reference to the Game this guess belongs to

    @ElementCollection
    @CollectionTable(name = "guess_combinations", joinColumns = @JoinColumn(name = "guess_id"))
    @Column(name = "combination")
    private List<Integer> guessCombination;  // The guess made by the player

    private String feedback;  // Feedback after making the guess

    public Guess() {
    }

    // Constructor to initialize a guess with the player's guess and the feedback
    public Guess(List<Integer> guessCombination, String feedback) {
        this.guessCombination = guessCombination;
        this.feedback = feedback;
    }

    // Getter and Setter for guessCombination
    public List<Integer> getGuessCombination() {
        return guessCombination;
    }

    public void setGuessCombination(List<Integer> guessCombination) {
        this.guessCombination = guessCombination;
    }

    // Getter and Setter for feedback
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    // Getter and Setter for game (Bidirectional mapping)
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
