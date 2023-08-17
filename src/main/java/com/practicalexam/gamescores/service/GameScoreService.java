package com.practicalexam.gamescores.service;

import com.practicalexam.gamescores.dto.GameScoreDTO;
import com.practicalexam.gamescores.entity.GameScore;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GameScoreService {

    public GameScoreDTO saveGameScore(GameScoreDTO gameScoreDTO);


    //since we are getting the highest scores in each game, we need a list
    List<GameScoreDTO> findHighestScoresForUser(Long userId);


}
