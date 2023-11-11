package com.team11.be.domain.game.controller;

import com.team11.be.domain.game.dto.GameRequestDto;
import com.team11.be.domain.game.dto.GameResponseDto;
import com.team11.be.domain.game.service.GameService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @Tag(name = "게임 정보 제출", description = "게임을 마치고 게임 정보와 유저 정보를 제출합니다")
    @PostMapping("/games")
    public void postGame(@Valid @ModelAttribute GameRequestDto gameRequestDto){
        gameService.postGame(gameRequestDto);
    }

    @Tag(name = "게임 정보 가져오기", description = "해당 게임의 유저 기록을 모두 가져옵니다")
    @GetMapping("/games")
    public List<GameResponseDto> getGame(){
        return gameService.getGameInfoList();
    }
}
