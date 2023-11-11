package com.team11.be.domain.game.dto;

import com.team11.be.domain.member.dto.MemberResponseDto;

public record GameResponseDto(Long id, Integer score, MemberResponseDto memberResponseDto) {
}
