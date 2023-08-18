package com.practicalexam.gamescores.dto;

import com.practicalexam.gamescores.entity.Game;
import com.practicalexam.gamescores.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameScoreDTO {
    private Long userId;
    private Long gameId;
    private int score;
    private LocalDateTime scoreDate;
}

/*Assuming no negative scores are added*/