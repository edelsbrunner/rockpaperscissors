package com.codechallenge.rockpaperscissors.resource;

import com.codechallenge.rockpaperscissors.type.GameSymbol;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameRequest {
    private GameSymbol playerSymbol;
}
