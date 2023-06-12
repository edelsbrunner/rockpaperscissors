package com.codechallenge.rockpaperscissors.resource;

import com.codechallenge.rockpaperscissors.type.GameResult;
import com.codechallenge.rockpaperscissors.type.GameSymbol;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GameResponse {
    private GameResult result;
    private GameSymbol opponentSymbol;
}
