package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.service.RankingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class RankingApi {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RankingService rankingService;
    @CrossOrigin
    @GetMapping("/ranking")
    public ResponseEntity getRanking() throws JsonProcessingException {
        List<Ranking> list = rankingService.getRanking();
return ResponseEntity.ok(objectMapper.writeValueAsString(list));
    }

    @PostMapping("/addRanking")
    public ResponseEntity addRanking(@RequestBody Ranking ranking){
        String response = rankingService.adRanking(ranking);
        return ResponseEntity.ok(response);
    }
    @CrossOrigin
    @RequestMapping("/ranking/{id}")
    public ResponseEntity getRankingById(@RequestParam Long id) throws JsonProcessingException {
       return ResponseEntity.ok(objectMapper.writeValueAsString(rankingService.getRankingById(id))) ;
    }
}
