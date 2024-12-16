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
    private Game game;

    @ElementCollection
    @CollectionTable(name = "guess_combinations", joinColumns = @JoinColumn(name = "guess_id"))
    @Column(name = "combination")
    private List<Integer> guessCombination;

    private String feedback;

    // Default constructor
    public Guess() {}

    // Constructor with parameters
    public Guess(List<Integer> guessCombination, String feedback) {
        this.guessCombination = guessCombination;
        this.feedback = feedback;
    }

    // Getter and Setter for game
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
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

    // Getter and Setter for id (if needed, generally for entity identification)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
