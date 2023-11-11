package com.team11.be.domain.game.service;

import com.team11.be.domain.game.dto.GameRequestDto;
import com.team11.be.domain.game.dto.GameResponseDto;
import com.team11.be.domain.game.model.Game;
import com.team11.be.domain.game.repository.GameRepository;
import com.team11.be.domain.member.dto.MemberResponseDto;
import com.team11.be.domain.member.model.Member;
import com.team11.be.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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
            MemberResponseDto memberResponseDto = new MemberResponseDto(member.getId(), member.getSchool(),
                    member.getGrade(), member.getClassNumber(), member.getMemberNumber(), member.getName());
            return new GameResponseDto(g.getId(), g.getScore(), memberResponseDto);
        }).toList();
    }
}
