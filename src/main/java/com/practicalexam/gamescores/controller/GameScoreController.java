package com.practicalexam.gamescores.controller;

import com.practicalexam.gamescores.dto.GameScoreDTO;
import com.practicalexam.gamescores.service.GameScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gamescore")
public class GameScoreController {

    @Autowired
    private GameScoreService gameScoreService;



    @PostMapping("/save")
    public ResponseEntity<GameScoreDTO> saveGameScore(@RequestBody GameScoreDTO gameScoreDTO) {
        GameScoreDTO savedScore = gameScoreService.saveGameScore(gameScoreDTO);
        return ResponseEntity.ok(savedScore);
    }

    @GetMapping("/{userId}/highestscores")
    public List<GameScoreDTO> getHighestScoresForUser(@PathVariable Long userId) {
        return gameScoreService.findHighestScoresForUser(userId);
    }


}



