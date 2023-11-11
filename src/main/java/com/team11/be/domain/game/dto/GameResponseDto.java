package com.team11.be.domain.game.dto;

import com.team11.be.domain.member.dto.MemberResponseDto;
import jakarta.validation.Valid;

public record GameResponseDto(Long id, Integer score, @Valid MemberResponseDto memberResponseDto) {
}
