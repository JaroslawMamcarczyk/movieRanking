package com.mamra.start.movies.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.movies.domain.Battle;
import com.mamra.start.movies.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BattleApi {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BattleService battleService;

    @CrossOrigin
    @GetMapping("/battle")
    public ResponseEntity getBattle() throws JsonProcessingException {
        List<Battle> list = battleService.getBattleList();
        return ResponseEntity.ok(objectMapper.writeValueAsString(list));
    }
}
