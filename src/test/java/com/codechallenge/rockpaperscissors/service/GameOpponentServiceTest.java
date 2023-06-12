package com.codechallenge.rockpaperscissors.service;

import com.codechallenge.rockpaperscissors.type.GameSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@SpringBootTest
class GameOpponentServiceTest {

    private GameOpponentService classUnderTest;

    @BeforeEach
    public void setUp() {
        classUnderTest = new GameOpponentService();
    }

    @Test
    public void testRandomSymbol() {
        GameSymbol result = classUnderTest.randomSymbol();
        assertThat(result, notNullValue());
    }

    @Test
    public void testPatternSymbol() {
        GameSymbol result = classUnderTest.patternSymbol(0);
        assertThat(result, is(GameSymbol.ROCK));
        result = classUnderTest.patternSymbol(1);
        assertThat(result, is(GameSymbol.ROCK));
        result = classUnderTest.patternSymbol(2);
        assertThat(result, is(GameSymbol.PAPER));
        result = classUnderTest.patternSymbol(3);
        assertThat(result, is(GameSymbol.SCISSORS));
    }

    @Test
    public void testAiSymbol() {
        GameSymbol result = classUnderTest.aiSymbol(List.of(GameSymbol.PAPER), GameService.symbolConfiguration);
        assertThat(result, is(GameSymbol.SCISSORS));
        result = classUnderTest.aiSymbol(List.of(GameSymbol.ROCK), GameService.symbolConfiguration);
        assertThat(result, is(GameSymbol.PAPER));
        result = classUnderTest.aiSymbol(List.of(GameSymbol.SCISSORS), GameService.symbolConfiguration);
        assertThat(result, is(GameSymbol.ROCK));
    }
}

