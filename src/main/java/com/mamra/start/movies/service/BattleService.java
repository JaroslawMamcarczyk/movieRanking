package com.mamra.start.movies.service;

import com.mamra.start.movies.domain.Battle;
import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.repository.BattleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleService {

    @Autowired
    private BattleRepository battleRepository;

    public List<Battle> getBattleList(){
        List<Battle> battleList = battleRepository.findAll();
        return battleList;
    }
    public List<Battle> findBattleForRankingAndMovie(Ranking ranking, Movie movie){
        List<Battle> battleList = battleRepository.findBattleForRankingAndMovie(ranking,movie);
        return battleList;
    }
}
