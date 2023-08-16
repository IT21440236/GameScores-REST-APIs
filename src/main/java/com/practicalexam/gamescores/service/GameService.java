package com.practicalexam.gamescores.service;

import com.practicalexam.gamescores.dto.GameDTO;
import com.practicalexam.gamescores.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface GameService{

    public GameDTO saveGame(GameDTO gameDTO);


}
