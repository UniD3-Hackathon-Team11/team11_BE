package com.team11.be.domain.game.service;

import com.team11.be.domain.game.dto.GameRequestDto;
import com.team11.be.domain.game.dto.GameResponseDto;
import com.team11.be.domain.game.model.Game;
import com.team11.be.domain.game.repository.GameRepository;
import com.team11.be.domain.member.model.Member;
import com.team11.be.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GameService {

    private final GameRepository gameRepository;
    private final MemberRepository memberRepository;

    public void postGame(GameRequestDto gameRequestDto){
        Member member = Member.builder().name(gameRequestDto.name()).memberNumber(gameRequestDto.memberNumber())
                .grade(gameRequestDto.grade()).classNumber(gameRequestDto.classNumber())
                .school(gameRequestDto.school()).build();
        Game game = Game.builder().score(gameRequestDto.score()).member(member).build();

        gameRepository.save(game);
        memberRepository.save(member);
    }

    public List<GameResponseDto> getGameInfoList(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(g -> {
            Member member = g.getMember();
            return new GameResponseDto(g.getId(), g.getScore(), member.getSchool(),
                    member.getGrade(), member.getClassNumber(), member.getMemberNumber(), member.getName());
        }).toList();
    }
}
