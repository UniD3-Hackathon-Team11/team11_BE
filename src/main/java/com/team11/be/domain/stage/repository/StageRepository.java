package com.team11.be.domain.stage.repository;

import com.team11.be.domain.stage.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StageRepository extends JpaRepository<Stage, Long> {
}
