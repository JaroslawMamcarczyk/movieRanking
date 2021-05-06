package com.mamra.start.remik.api;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.remik.domain.Game;
import com.mamra.start.remik.service.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GameApi {
    private GameService gameService;
    private ObjectMapper objectMapper;

    GameApi(GameService gameService, ObjectMapper objectMapper){
        this.gameService = gameService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/games")
    public ResponseEntity getPlayers() throws JsonProcessingException {
        List<Game> gameList = gameService.getGame();
        return ResponseEntity.ok(objectMapper.writeValueAsString(gameList));
    }

    @PostMapping("/games/add")
    public ResponseEntity addPlayer(@RequestBody Game game) throws JsonProcessingException {
        gameService.addGame(game);
        return ResponseEntity.ok("OK");
    }
}
