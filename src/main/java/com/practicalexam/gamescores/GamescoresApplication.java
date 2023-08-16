package com.practicalexam.gamescores;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GamescoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamescoresApplication.class, args);
	}

	//This model mapper was added by using the modelmapper dependency
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
