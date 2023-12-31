package com.team11.be.domain.game.repository;

import com.team11.be.domain.game.model.Game;
import com.team11.be.domain.stage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> getGamesByStageOrderByScoreDesc(Stage stage);
}
