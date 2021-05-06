package com.mamra.start.remik.service;

import com.mamra.start.remik.domain.Player;
import com.mamra.start.remik.repository.PlayerRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PlayerService {
    PlayerRepository playerRepository;

    PlayerService (PlayerRepository playerRepository){this.playerRepository=playerRepository;}

    public List<Player> getPlayerList(){
        return playerRepository.findAll();
    }

    public void addPlayer(Player player){
        playerRepository.save(player);
    }

}
