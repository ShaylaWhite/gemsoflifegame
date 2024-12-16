package com.gemsoflifegame.repository;

import com.gemsoflifegame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    // Custom query to get all completed games
    List<Game> findByAttemptsRemaining(int attemptsRemaining);

    // Example: Get games by the user's ID (assuming you add user field to Game)
    List<Game> findByUserId(Long userId);
}
