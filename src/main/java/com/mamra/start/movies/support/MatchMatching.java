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
    BattleService battleService;
    RankingService rankingService;

    private List<Movie> listMovie;
    private  Movie movie;
    private Movie opponent;
    private Ranking ranking;
    private  List<Battle> battleList;

    public MatchMatching(Long id,RankingService rankingService,BattleService battleService) {
        this.battleService = battleService;
        this.rankingService = rankingService;
        if (rankingService.getRankingById(id)!=null) {
            ranking = rankingService.getRankingById(id);
            listMovie = ranking.getRankingMovie();
            movie = randomMovie(listMovie);
            opponent = randomMovie(createOpponentsList(movie));
            System.out.println("Gospodarz:"+movie.getTitle());
            System.out.println("Przeciwnik:"+opponent.getTitle());
        }
    }

    public Movie randomMovie(List<Movie> list){
        Random random = new Random();
        return list.get(random.nextInt(list.size()));
    }

    public List<Movie> createOpponentsList(Movie movie){
        List<Movie> opponentsList = new ArrayList(listMovie);
        opponentsList.remove(movie);
        battleList = battleService.findBattleForRankingAndMovie(ranking,movie);
        for (Battle battle:battleList
             ) {
            opponentsList.remove(battle.getFirstMovie());
            opponentsList.remove(battle.getSecondMovie());
        }
        return opponentsList;
    }
}
