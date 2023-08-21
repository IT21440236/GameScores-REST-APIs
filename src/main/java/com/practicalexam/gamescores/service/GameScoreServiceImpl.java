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

import java.time.LocalDateTime;
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

            // Create a new record
            GameScore gameScore = new GameScore();
            gameScore.setUser(user);
            gameScore.setGame(game);
            gameScore.setScore(gameScoreDTO.getScore());
            // Set the scoreDate to the current timestamp
            gameScore.setScoreDate(LocalDateTime.now());
            gameScoreRepository.save(gameScore);

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


/*NOTES

•	One key feature of Streams is their lazy evaluation.
This means that intermediate operations (like map, filter, etc.) are not executed
until a terminal operation (like collect) is invoked. This can help optimize performance
by avoiding unnecessary processing.
=====================================

we need to use the stream becuz we are not just mapping a single GameScore entity to a
GameScoreDTO object.

Here we are dealing with a list of GameScore entities
* */

