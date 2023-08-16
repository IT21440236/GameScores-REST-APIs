package com.practicalexam.gamescores;

import com.practicalexam.gamescores.entity.Game;
import com.practicalexam.gamescores.entity.User;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameScoreKey implements Serializable {
        private User user;
        private Game game;
}

