package com.mamra.start.movies.service;

import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.repository.RankingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RankingService {

private RankingRepository rankingRepository;

RankingService(RankingRepository rankingRepository){
    this.rankingRepository = rankingRepository;
}

public List<Ranking> getRanking(){
  return  rankingRepository.findAll();
}

public String adRanking(Ranking ranking){
    Optional<Ranking> rankingFromDb = rankingRepository.findById(ranking.getId());
    if(rankingFromDb.isPresent()){
        return "Ranking już istnieje";
    }else{
        rankingRepository.save(ranking);
        return ranking.getRankingCategory()+" został stworzony";
    }

}

public Ranking getRankingById(Long id){
    Optional<Ranking> ranking = rankingRepository.findById(id);
    return ranking.orElse(null);
}

}
