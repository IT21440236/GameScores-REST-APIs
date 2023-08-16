package com.practicalexam.gamescores.entity;

import com.practicalexam.gamescores.GameScoreKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(GameScoreKey.class)
public class GameScore {

        @Id
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @Id
        @ManyToOne
        @JoinColumn(name = "game_id")
        private Game game;

        private int score;

}

/*
Taking the relationship between User and Game as N:M
Created a separate table for the relationship along with the descriptive attribute score.

This table will have the PKs of both User and Game as FKs.

This table will have a composite PK

Decided to take the relationship as N:M to reduce redundancies.



* */

