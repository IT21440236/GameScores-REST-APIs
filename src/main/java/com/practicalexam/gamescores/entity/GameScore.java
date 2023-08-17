package com.practicalexam.gamescores.entity;

import com.practicalexam.gamescores.GameScoreKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(GameScoreKey.class)
public class GameScore {

        @Id
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        @Id
        @ManyToOne
        @JoinColumn(name = "game_id")
        private Game game;

        private int score;

}

/*
Taking the relationship between User and Game as N:M
Created a separate table for the relationship along with the descriptive
attribute score.

This table will have the PKs of both User and Game as FKs.

This table will have a composite PK

Decided to take the relationship as N:M to reduce redundancies.
* */



/*NOTES
*
In the provided GameScore entity class, the @ManyToOne and @JoinColumn annotations
* are used to define the relationships between the GameScore entity and the User and
*  Game entities. Let's break down each part:

@ManyToOne: This annotation indicates a many-to-one relationship between the
* GameScore entity and the User and Game entities. This means that multiple
* GameScore entities can be associated with a single User or Game entity.
* In other words, each GameScore is linked to a specific User and a specific Game.

@JoinColumn(name = "user_id"): This annotation specifies the column in the
* GameScore table that will store the foreign key to the User entity.
* The name attribute defines the name of the column, and in this case, it's
* set to "user_id". This column will establish the relationship between a
*  GameScore entry and a specific User.

@JoinColumn(name = "game_id"): Similarly, this annotation specifies the
* column in the GameScore table that will store the foreign key to the
* Game entity. The name attribute is set to "game_id". This column will
* establish the relationship between a GameScore entry and a specific Game.

Regarding your question about @ManytoOne vs @ManytoMany: In this
* context, a @ManyToOne relationship is used because a GameScore is
* associated with one specific User and one specific Game. If
* it were a @ManyToMany relationship, it would imply that a single
* GameScore entry could be associated with multiple Users and multiple Games,
* which might not be suitable for your use case.

To summarize, the annotations used in the GameScore entity help
* define the relationships and foreign keys needed to connect GameScore
* entries with the corresponding User and Game entities, allowing you to
* establish a structured and meaningful database schema for your gaming platform.
*
* */

