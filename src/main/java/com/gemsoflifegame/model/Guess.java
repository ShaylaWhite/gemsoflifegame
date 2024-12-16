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

    public Guess() {}

    public Guess(List<Integer> guessCombination, String feedback) {
        this.guessCombination = guessCombination;
        this.feedback = feedback;
    }

    // Getters and Setters
}
