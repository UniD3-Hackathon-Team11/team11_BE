package com.team11.be.domain.stage.service;

import com.team11.be.domain.stage.dto.StageRequestDto;
import com.team11.be.domain.stage.dto.StageResponseDto;
import com.team11.be.domain.stage.model.Stage;
import com.team11.be.domain.stage.repository.StageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StageService {

    private final StageRepository stageRepository;

    public Stage getStage(Long id){
        return stageRepository.findById(id).orElseThrow(() -> new RuntimeException("아직 없는 게임이에요"));
    }

    public void postStage(StageRequestDto stageRequestDto){
        Stage stage = Stage.builder().targetScore(stageRequestDto.targetScore())
                .timeLimit(stageRequestDto.targetLimit()).build();

        stageRepository.save(stage);
    }

    public List<StageResponseDto> getAllStages(){
        List<Stage> stages = stageRepository.findAll();
        return stages.stream().map(s -> new StageResponseDto(s.getId(), s.getTargetScore(), s.getTimeLimit())).toList();
    }
}
