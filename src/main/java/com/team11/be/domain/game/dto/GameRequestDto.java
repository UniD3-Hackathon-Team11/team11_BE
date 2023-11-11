package com.team11.be.domain.game.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public record GameRequestDto(String school, Integer grade, Integer classNumber, Integer memberNumber, String name, Integer score) {
}
