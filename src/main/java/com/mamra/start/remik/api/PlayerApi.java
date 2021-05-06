package com.mamra.start.remik.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mamra.start.remik.domain.Player;
import com.mamra.start.remik.service.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PlayerApi {
    private PlayerService playerService;
    private ObjectMapper objectMapper;

    PlayerApi(PlayerService playerService, ObjectMapper objectMapper){
        this.playerService = playerService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/players")
    public ResponseEntity getPlayers() throws JsonProcessingException {
        List<Player> playerList = playerService.getPlayerList();
        return ResponseEntity.ok(objectMapper.writeValueAsString(playerList));
    }

    @PostMapping("/players/add")
    public ResponseEntity addPlayer(@RequestBody Player player) throws JsonProcessingException {
        playerService.addPlayer(player);
        return ResponseEntity.ok("OK");
    }

}
