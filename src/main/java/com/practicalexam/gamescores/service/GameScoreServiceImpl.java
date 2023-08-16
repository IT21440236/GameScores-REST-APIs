package com.practicalexam.gamescores.service;

import com.practicalexam.gamescores.dto.GameScoreDTO;
import com.practicalexam.gamescores.entity.Game;
import com.practicalexam.gamescores.entity.User;
import com.practicalexam.gamescores.repository.GameRepository;
import com.practicalexam.gamescores.repository.GameScoreRepository;
import com.practicalexam.gamescores.entity.GameScore;
import com.practicalexam.gamescores.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GameScoreServiceImpl implements GameScoreService {

    @Autowired
    private GameScoreRepository gameScoreRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public GameScoreDTO saveGameScore(GameScoreDTO gameScoreDTO) {
        Optional<User> userOptional = userRepository.findById(gameScoreDTO.getUserId());
        Optional<Game> gameOptional = gameRepository.findById(gameScoreDTO.getGameId());

        if (userOptional.isPresent() && gameOptional.isPresent()) {
            User user = userOptional.get();
            Game game = gameOptional.get();

            GameScore gameScore = new GameScore();
            gameScore.setUser(user);
            gameScore.setGame(game);
            gameScore.setScore(gameScoreDTO.getScore());

            gameScoreRepository.save(gameScore);

            return modelMapper.map(gameScore, GameScoreDTO.class);
        }

        throw new IllegalArgumentException("User or game not found with the provided IDs.");
    }



    @Override
    public List<GameScoreDTO> findHighestScoresForUser(Long userId) {
        List<GameScore> highestScores = gameScoreRepository.findHighestScoresForUser(userId);

        List<GameScoreDTO> highestScoreDTOs = highestScores.stream()
                .map(gameScore -> modelMapper.map(gameScore, GameScoreDTO.class))
                .collect(Collectors.toList());

        return highestScoreDTOs;
    }




}


/*Regarding saveScore method

Initially we pass the userId , and enter the gameId manually

But can be improved to pass both userId and gameId and check the validity of both
before saving a score.
* */