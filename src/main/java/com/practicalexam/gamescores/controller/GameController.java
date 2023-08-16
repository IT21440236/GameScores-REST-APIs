package com.practicalexam.gamescores.controller;

import com.practicalexam.gamescores.dto.GameDTO;
import com.practicalexam.gamescores.dto.GameScoreDTO;
import com.practicalexam.gamescores.dto.UserDTO;
import com.practicalexam.gamescores.entity.GameScore;
import com.practicalexam.gamescores.service.GameService;
import com.practicalexam.gamescores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public GameDTO saveGame(@RequestBody GameDTO gameDTO){
        return gameService.saveGame(gameDTO);
    }

}


/*
For the retrieval of games's top 10 highest scores can use can algorithm like
mergesort or quicksort

OR

Use Max Heap Priority Queue in combination with Hashmap

* */
