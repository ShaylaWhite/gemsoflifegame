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
    private List<Integer> secretCombination = new ArrayList<>();

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Guess> guesses = new ArrayList<>();

    private int attemptsRemaining;
    private String lifeLesson;

    public Game() {
        this.attemptsRemaining = 10;
        this.lifeLesson = "Perseverance";
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

    // Getter and Setter for lifeLesson (if needed)
    public String getLifeLesson() {
        return lifeLesson;
    }

    public void setLifeLesson(String lifeLesson) {
        this.lifeLesson = lifeLesson;
    }
}

