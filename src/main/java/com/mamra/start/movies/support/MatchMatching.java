package com.mamra.start.movies.support;

import com.mamra.start.movies.domain.Battle;
import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.service.BattleService;
import com.mamra.start.movies.service.RankingService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Getter
@Setter
public class MatchMatching {
    @Autowired
    BattleService battleService;
    @Autowired
    RankingService rankingService;

    private List<Movie> listMovie;
    private  Movie movie;
    private Movie opponent;
    private Ranking ranking;

    public MatchMatching(Long id) {
        if (rankingService.getRankingById(id).isPresent()) {
            ranking = rankingService.getRankingById(id).get();
            listMovie = ranking.getRankingMovie();
            movie = randomMovie(listMovie);
            opponent = randomMovie(createOpponentsList(movie));
        }
    }

    public Movie randomMovie(List<Movie> list){
        Random random = new Random(list.size());
        return list.get(random.nextInt());
    }

    public List<Movie> createOpponentsList(Movie movie){
        List<Movie> movieList = new ArrayList<>();
        List<Movie> opponentList = new ArrayList<>(movieList);
       List<Battle> battleList = battleService.findBattleForRankingAndMovie(ranking,movie);
            for (Battle battle:battleList) {
               if(battle.getFirstMovie().equals(movie)){
                   movieList.add(battle.getSecondMovie());
               }else{
                   movieList.add(battle.getFirstMovie());
               }
            }
        movieList.add(movie);
        opponentList.removeAll(movieList);
        return opponentList;
    }
}
