package com.practicalexam.gamescores.service;

import com.practicalexam.gamescores.dto.GameDTO;
import com.practicalexam.gamescores.entity.Game;
import com.practicalexam.gamescores.entity.User;
import com.practicalexam.gamescores.repository.GameRepository;
import com.practicalexam.gamescores.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public GameDTO saveGame(GameDTO gameDTO) {
        gameRepository.save(modelMapper.map(gameDTO, Game.class));
        return gameDTO;
    }
}
