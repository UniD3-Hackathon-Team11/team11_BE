package com.team11.be.domain.game.model;

import com.team11.be.domain.member.model.Member;
import jakarta.persistence.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer score;
    @ManyToOne
    private Member member;
}
