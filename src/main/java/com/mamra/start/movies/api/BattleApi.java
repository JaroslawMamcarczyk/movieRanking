package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.Battle;
import com.mamra.start.movies.domain.Movie;
import com.mamra.start.movies.service.BattleService;
import com.mamra.start.movies.service.MovieService;
import com.mamra.start.movies.service.RankingService;
import com.mamra.start.movies.support.MatchMatching;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BattleApi {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BattleService battleService;
    @Autowired
    private MovieService movieService;
    @Autowired
    private RankingService rankingService;

    @CrossOrigin
    @GetMapping("/battle")
    public ResponseEntity getBattle() throws JsonProcessingException {
        List<Battle> list = battleService.getBattleList();
        return ResponseEntity.ok(objectMapper.writeValueAsString(list));
    }
    @CrossOrigin
    @GetMapping("/battle/{}")
    public ResponseEntity createBattle(@RequestParam Long id) throws  JsonProcessingException{
        Movie [] movieTable = new Movie[2];
        MatchMatching matchMatching = new MatchMatching(id);
        movieTable[0] = matchMatching.getMovie();
        movieTable[1] = matchMatching.getOpponent();
        return ResponseEntity.ok(objectMapper.writeValueAsString(movieTable));
    }

    @CrossOrigin
    @GetMapping("/test/{}")
    public ResponseEntity test(@RequestParam Long id) throws JsonProcessingException{
    // List<Battle> list =  battleService.findBattleForRankingAndMovie(rankingService.getRankingById(id).get(), movieService.getMovieById(id).get());
    MatchMatching matchMatching = new MatchMatching(id);
    List<Movie> movieList = new ArrayList<>();
    movieList.add(matchMatching.getMovie());
    movieList.add(matchMatching.getOpponent());
        return ResponseEntity.ok(objectMapper.writeValueAsString(movieList));
    }

}
