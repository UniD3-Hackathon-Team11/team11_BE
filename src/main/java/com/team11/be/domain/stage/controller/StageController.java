package com.team11.be.domain.stage.controller;

import com.team11.be.domain.stage.dto.StageResponseDto;
import com.team11.be.domain.stage.service.StageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StageController {

    private final StageService stageService;

    @Tag(name = "스테이지 정보 받기", description = "스테이지 정보를 받아옵니다")
    @GetMapping("/stages/{stageId}")
    public StageResponseDto getStage(@PathVariable Long stageId){
        return stageService.getStageResponse(stageId);
    }
}
