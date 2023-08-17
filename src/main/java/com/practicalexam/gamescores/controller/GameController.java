package com.practicalexam.gamescores.controller;

import com.practicalexam.gamescores.dto.GameDTO;
import com.practicalexam.gamescores.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/games")
public class GameController {

    @Autowired
    private GameService gameService;


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
