package com.codechallenge.rockpaperscissors.controller;

import com.codechallenge.rockpaperscissors.resource.GameRequest;
import com.codechallenge.rockpaperscissors.resource.GameResponse;
import com.codechallenge.rockpaperscissors.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "v1")
public class GameController {

    private final GameService gameService;

    public GameController(@Autowired GameService gameService) {
        this.gameService = gameService;
    }

    @CrossOrigin
    @PostMapping("/game")
    public ResponseEntity<GameResponse> postGenerateGameResult(@RequestBody GameRequest gameRequest) {
        return ResponseEntity.ok(gameService.generateGameResult(gameRequest.getPlayerSymbol()));
    }
}
