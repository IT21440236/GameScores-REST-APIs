package com.practicalexam.gamescores.repository;

import com.practicalexam.gamescores.entity.Game;
import com.practicalexam.gamescores.entity.GameScore;
import com.practicalexam.gamescores.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface GameScoreRepository extends JpaRepository<GameScore, Long> {
    @Query("SELECT gs FROM GameScore gs, User " +
            "WHERE gs.user.id = :userId " +
            "AND gs.score = (SELECT MAX(gs2.score) FROM GameScore gs2 WHERE gs2.game = gs.game AND gs2.user = gs.user)")
    List<GameScore> findHighestScoresForUser(@Param("userId") Long userId);


}




/*NOTES

SELECT gs
FROM GameScore gs
WHERE gs.user.id = :userId
AND gs.score = (
	SELECT MAX(gs2.score)
	FROM GameScore gs2
	WHERE gs2.game = gs.game AND g2.user = gs.user
)

#Inner query condition
WHERE gs2.game = gs.game AND g2.user = gs.user

#game selected from inner query and outer query should be same.
#Same applies for the user
* */