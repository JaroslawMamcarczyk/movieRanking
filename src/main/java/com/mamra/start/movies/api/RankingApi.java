package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.api.response.RankingResponse;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.service.RankingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class RankingApi {
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    RankingService rankingService;

    @GetMapping("/ranking")
    public ResponseEntity getRanking() throws JsonProcessingException {
        List<Ranking> list = rankingService.getRanking();
        List<RankingResponse> responseList = new ArrayList<>();
        for (Ranking ranking: list) {
            responseList.add(new RankingResponse(ranking));
        }
return ResponseEntity.ok(objectMapper.writeValueAsString(responseList));
    }

    @PostMapping("/ranking")
    public ResponseEntity addRanking(@RequestBody Ranking ranking){
        String response = rankingService.adRanking(ranking);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/ranking/{}")
    public ResponseEntity getRankingById(@RequestParam Long id) throws JsonProcessingException {
       return ResponseEntity.ok(objectMapper.writeValueAsString(rankingService.getRankingById(id))) ;
    }

}
