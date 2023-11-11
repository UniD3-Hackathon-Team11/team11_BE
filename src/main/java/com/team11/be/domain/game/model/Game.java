package com.team11.be.domain.game.model;

import com.team11.be.domain.member.model.Member;
import com.team11.be.domain.stage.model.Stage;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer score;
    @ManyToOne
    private Member member;
    @ManyToOne
    private Stage stage;
}
