package com.practicalexam.gamescores.repository;

import com.practicalexam.gamescores.entity.GameScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameScoreRepository extends JpaRepository<GameScore, Long> {
    @Query("SELECT gs FROM GameScore gs " +
            "WHERE gs.user.id = :userId " +
            "AND gs.score = (SELECT MAX(gs2.score) FROM GameScore gs2 WHERE gs2.game = gs.game AND gs2.user = gs.user)")
    List<GameScore> findHighestScoresForUser(@Param("userId") Long userId);
}
