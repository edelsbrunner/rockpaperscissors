package com.codechallenge.rockpaperscissors.service;

import com.codechallenge.rockpaperscissors.type.GameSymbol;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class GameOpponentService {

    public static final int REPEAT_PATTERN_EVERY_FOUR_MOVES = 4;

    public GameSymbol randomSymbol()  {
        Random random = new Random();
        GameSymbol[] symbols = GameSymbol.values();
        return symbols[random.nextInt(symbols.length)];
    }
    public GameSymbol patternSymbol(int numberOfSymbolsPicked)  {
        GameSymbol[] pattern = {GameSymbol.ROCK, GameSymbol.ROCK, GameSymbol.PAPER, GameSymbol.SCISSORS};
        int symbolNumberToPick = (numberOfSymbolsPicked % REPEAT_PATTERN_EVERY_FOUR_MOVES);

        return pattern[symbolNumberToPick];
    }

    public GameSymbol aiSymbol(List<GameSymbol> listOfLastPickedSymbols, Map<GameSymbol, GameSymbol> symbolConfiguration)  {
        if (!listOfLastPickedSymbols.isEmpty()) {
            GameSymbol mostFrequentMove = getMostFrequentMove(listOfLastPickedSymbols);
            return getCounterSymbol(symbolConfiguration, mostFrequentMove);
        }
        return randomSymbol();
    }

    private GameSymbol getCounterSymbol(Map<GameSymbol, GameSymbol> symbolConfiguration, GameSymbol mostFrequentMove) {
        return symbolConfiguration.entrySet().stream()
                .filter(entry -> entry.getValue().equals(mostFrequentMove))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    private GameSymbol getMostFrequentMove(List<GameSymbol> listOfLastPickedSymbols) {
        return listOfLastPickedSymbols.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
