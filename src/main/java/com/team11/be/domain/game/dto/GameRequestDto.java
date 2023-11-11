package com.team11.be.domain.game.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public record GameRequestDto(String school, Integer grade, Integer classNumber, Integer memberNumber, @NotNull(message = "이름을 입력해주세요!!") String name, Integer score) {
}
