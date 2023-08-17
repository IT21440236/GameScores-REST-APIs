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

            //converting a entity to a DTO here
            return modelMapper.map(gameScore, GameScoreDTO.class);

            //return gameScoreRepository.save(modelMapper.map(gameScore, GameScoreDTO.class));
        }

        throw new IllegalArgumentException("User or game not found with the provided IDs.");
    }
//In the above method I'm dealing with the GameScoreDTO object rather than the
// entity itself like in Game and User is becuz, here the GameScoreDTO is
// lighter in weight than the GameScore entity.


    @Override
    public List<GameScoreDTO> findHighestScoresForUser(Long userId) {
        // Retrieve the list of highest scores for the given user from the repository
        List<GameScore> highestScores = gameScoreRepository.findHighestScoresForUser(userId);

        // Map the list of GameScore entities to a list of GameScoreDTO using ModelMapper
        List<GameScoreDTO> highestScoreDTOs = highestScores.stream()
                .map(gameScore -> modelMapper.map(gameScore, GameScoreDTO.class))
                .collect(Collectors.toList());

        // Return the list of GameScoreDTO representing the highest scores for the user
        return highestScoreDTOs;
    }




}


