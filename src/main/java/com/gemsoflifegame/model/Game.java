package com.gemsoflifegame.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "secret_combinations", joinColumns = @JoinColumn(name = "game_id"))
    @Column(name = "combination")
    private List<Integer> secretCombination = new ArrayList<>();  // Storing the secret combination

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Guess> guesses = new ArrayList<>();  // List of guesses for this game

    private int attemptsRemaining;
    private String lifeLesson;

    public Game() {
        this.attemptsRemaining = 10;
        this.lifeLesson = "Perseverance";
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getSecretCombination() {
        return secretCombination;
    }

    public void setSecretCombination(List<Integer> secretCombination) {
        this.secretCombination = secretCombination;
    }

    public List<Guess> getGuesses() {
        return guesses;
    }

    public void setGuesses(List<Guess> guesses) {
        this.guesses = guesses;
    }

    public int getAttemptsRemaining() {
        return attemptsRemaining;
    }

    public void setAttemptsRemaining(int attemptsRemaining) {
        this.attemptsRemaining = attemptsRemaining;
    }

    public String getLifeLesson() {
        return lifeLesson;
    }

    public void setLifeLesson(String lifeLesson) {
        this.lifeLesson = lifeLesson;
    }
}
