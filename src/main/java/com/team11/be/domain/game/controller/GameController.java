package com.team11.be.domain.game.controller;

import com.team11.be.domain.game.dto.GameRequestDto;
import com.team11.be.domain.game.dto.GameResponseDto;
import com.team11.be.domain.game.service.GameService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @PostMapping("/games")
    public void postGame(@Valid GameRequestDto gameRequestDto){
        gameService.postGame(gameRequestDto);
    }

    @GetMapping("/games")
    public List<GameResponseDto> getGame(){
        return gameService.getGameInfoList();
    }
}
