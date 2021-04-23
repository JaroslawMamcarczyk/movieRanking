package com.mamra.start.movies.service;

import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.repository.RankingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

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

@CrossOrigin
public String addRanking(Ranking ranking){
        rankingRepository.save(ranking);
        return ranking.getRankingCategory()+" został stworzony";

}

public Ranking getRankingById(Long id){
    Optional<Ranking> ranking = rankingRepository.findById(id);
    return ranking.get();
}

}
