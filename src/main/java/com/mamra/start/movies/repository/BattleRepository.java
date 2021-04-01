package com.mamra.start.movies.repository;

import com.mamra.start.movies.domain.Battle;
import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.domain.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BattleRepository extends JpaRepository<Battle,Long> {
    @Query("Select b from  Battle b where b.ranking=:ranking AND b.firstMovie=:firstMovie OR b.secondMovie =:firstMovie")
    List<Battle> findBattleForRankingAndMovie(@Param("ranking") Ranking ranking,@Param("firstMovie") Movie movie);
}
