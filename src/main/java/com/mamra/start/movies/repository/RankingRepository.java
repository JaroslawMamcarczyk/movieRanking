package com.mamra.start.movies.repository;

import com.mamra.start.movies.domain.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface RankingRepository extends JpaRepository<Ranking,Long> {
    //Optional<Ranking> findByCategory(String category);
}
