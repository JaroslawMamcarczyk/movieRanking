package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.Ranking;
import com.mamra.start.movies.service.RankingService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return ResponseEntity.ok(objectMapper.writeValueAsString(list));
    }

    @PostMapping("/ranking")
    public ResponseEntity addRanking(@RequestBody Ranking ranking){
        String response = rankingService.adRanking(ranking);
        return ResponseEntity.ok(response);
    }
}
