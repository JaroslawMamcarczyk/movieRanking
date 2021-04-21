package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.api.response.RankingResponse;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.service.RankingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

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
@CrossOrigin
    @PostMapping("/ranking/add")
    public ResponseEntity addRanking(@RequestBody RankingResponse response){
        Ranking rank = new Ranking(response.getRankingCategory(), response.getDescription());
        System.out.println(response.getRankingCategory());
        //rankingService.addRanking(rank);
        return ResponseEntity.ok(rank);
    }
    @CrossOrigin
    @RequestMapping("/ranking/{id}")
    public ResponseEntity getRankingById(@RequestParam Long id) throws JsonProcessingException {
       return ResponseEntity.ok(objectMapper.writeValueAsString(rankingService.getRankingById(id))) ;
    }
}
