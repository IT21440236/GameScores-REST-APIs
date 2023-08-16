package com.practicalexam.gamescores.dto;

import com.practicalexam.gamescores.entity.Game;
import com.practicalexam.gamescores.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameScoreDTO {
    private Long userId;
    private Long gameId;
    private int score;
}

/*Assuming no negative scores are added*/