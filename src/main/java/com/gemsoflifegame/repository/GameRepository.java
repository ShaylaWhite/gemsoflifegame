package com.gemsoflifegame.repository;

import com.gemsoflifegame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    // Query methods if needed
    List<Game> findByAttemptsRemaining(int attemptsRemaining);
}
