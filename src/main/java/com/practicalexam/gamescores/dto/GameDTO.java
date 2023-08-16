package com.practicalexam.gamescores.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GameDTO {
    private Long id;
    private String name;
    private String description;
    private int score;
}
