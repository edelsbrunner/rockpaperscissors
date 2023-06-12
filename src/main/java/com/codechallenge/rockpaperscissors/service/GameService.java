package com.codechallenge.rockpaperscissors.service;

import com.codechallenge.rockpaperscissors.type.GameMode;
import com.codechallenge.rockpaperscissors.type.GameResult;
import com.codechallenge.rockpaperscissors.resource.GameResponse;
import com.codechallenge.rockpaperscissors.type.GameSymbol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameService {
    @Value("${game.mode}")
    private GameMode gameMode;
    private final GameOpponentService opponentService;
    private static final List<GameSymbol> listOfLastPickedSymbols;

    public GameService(@Autowired GameOpponentService opponentService) {
        this.opponentService = opponentService;
    }

    static final Map<GameSymbol, GameSymbol> symbolConfiguration = new HashMap<>();
    static {
        // a list of which symbol beats which symbol
        symbolConfiguration.put(GameSymbol.ROCK, GameSymbol.SCISSORS);
        symbolConfiguration.put(GameSymbol.PAPER, GameSymbol.ROCK);
        symbolConfiguration.put(GameSymbol.SCISSORS, GameSymbol.PAPER);

        listOfLastPickedSymbols = new ArrayList<>();
    }

    public GameResponse generateGameResult(GameSymbol userSymbol) {
        GameSymbol opponentSymbol = gameMode.equals(GameMode.RANDOM) ? opponentService.randomSymbol() : gameMode.equals(GameMode.PATTERN) ? opponentService.patternSymbol(listOfLastPickedSymbols.size()) : opponentService.aiSymbol(listOfLastPickedSymbols, symbolConfiguration);
        GameResult result = symbolConfiguration.get(userSymbol).equals(opponentSymbol) ? GameResult.VICTORY : userSymbol == opponentSymbol ? GameResult.EQUAL : GameResult.LOSE;

        if (gameMode.equals(GameMode.PATTERN)) {
            listOfLastPickedSymbols.add(opponentSymbol);
        } else if (gameMode.equals(GameMode.AI)) {
            listOfLastPickedSymbols.add(userSymbol);
        }

        return GameResponse.builder().result(result).opponentSymbol(opponentSymbol).build();
    }

}
