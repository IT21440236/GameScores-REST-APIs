package com.practicalexam.gamescores.controller;

import com.practicalexam.gamescores.dto.UserDTO;
import com.practicalexam.gamescores.entity.User;
import com.practicalexam.gamescores.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping ("/save")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
}
