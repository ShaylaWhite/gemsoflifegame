package com.gemsoflifegame.repository;

import com.gemsoflifegame.model.Guess;
import org.glassfish.jaxb.runtime.v2.schemagen.xmlschema.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuessRepository extends JpaRepository<Guess, Long> {
    List<Guess> findByGameId(Long gameId);
}
