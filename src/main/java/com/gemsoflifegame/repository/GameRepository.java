package com.gemsoflifegame.repository;

import com.gemsoflifegame.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByAttemptsRemaining(int attemptsRemaining);
}
