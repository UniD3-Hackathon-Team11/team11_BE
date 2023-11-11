package com.team11.be.domain.game.repository;

import com.team11.be.domain.game.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
