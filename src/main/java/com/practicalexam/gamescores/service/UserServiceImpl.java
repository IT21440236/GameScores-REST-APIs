package com.practicalexam.gamescores.service;

import com.practicalexam.gamescores.dto.GameScoreDTO;
import com.practicalexam.gamescores.dto.UserDTO;
import com.practicalexam.gamescores.entity.GameScore;
import com.practicalexam.gamescores.entity.User;
import com.practicalexam.gamescores.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    private UserRepository userRepository;



    @Autowired
    private ModelMapper modelMapper;

    //Saving a user
    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }



}
