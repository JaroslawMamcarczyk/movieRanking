package com.mamra.start.remik.service;

import com.mamra.start.remik.domain.Game;
import com.mamra.start.remik.repository.GameRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GameService {
    private GameRepository gameRepository;
    GameService(GameRepository gameRepository){this.gameRepository=gameRepository;}

    public List getGame(){
        return gameRepository.findAll();
    }

    public void addGame(Game game){
        gameRepository.save(game);
    }
}
