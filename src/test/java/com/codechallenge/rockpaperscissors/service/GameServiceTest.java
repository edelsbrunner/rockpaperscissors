package com.codechallenge.rockpaperscissors.service;

import com.codechallenge.rockpaperscissors.type.GameMode;
import com.codechallenge.rockpaperscissors.type.GameResult;
import com.codechallenge.rockpaperscissors.resource.GameResponse;
import com.codechallenge.rockpaperscissors.type.GameSymbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GameServiceTest {

    @Mock
    private GameOpponentService mockedOpponentService;
    private GameService classUnderTest;

    @BeforeEach
    public void setUp() {
        classUnderTest = new GameService(mockedOpponentService);
    }

    @Test
    public void testGenerateGameResultWithRockAndPaperInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.PAPER);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.ROCK);
        assertThat(result.getResult(), is(GameResult.LOSE));
    }

    @Test
    public void testGenerateGameResultWithRockAndRockInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.ROCK);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.ROCK);
        assertThat(result.getResult(), is(GameResult.EQUAL));
    }

    @Test
    public void testGenerateGameResultWithRockAndScissorInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.SCISSORS);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.ROCK);
        assertThat(result.getResult(), is(GameResult.VICTORY));
    }

    @Test
    public void testGenerateGameResultWithPaperAndRockInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.ROCK);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.PAPER);
        assertThat(result.getResult(), is(GameResult.VICTORY));
    }

    @Test
    public void testGenerateGameResultWithPaperAndPaperInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.PAPER);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.PAPER);
        assertThat(result.getResult(), is(GameResult.EQUAL));
    }

    @Test
    public void testGenerateGameResultWithPaperAndScissorInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.SCISSORS);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.PAPER);
        assertThat(result.getResult(), is(GameResult.LOSE));
    }

    @Test
    public void testGenerateGameResultWithScissorAndRockInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.ROCK);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.SCISSORS);
        assertThat(result.getResult(), is(GameResult.LOSE));
    }

    @Test
    public void testGenerateGameResultWithScissorAndPaperInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.PAPER);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.SCISSORS);
        assertThat(result.getResult(), is(GameResult.VICTORY));
    }

    @Test
    public void testGenerateGameResultWithScissorAndScissorInRandomMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.RANDOM);
        when(mockedOpponentService.randomSymbol()).thenReturn(GameSymbol.SCISSORS);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.SCISSORS);
        assertThat(result.getResult(), is(GameResult.EQUAL));
    }

    @Test
    public void testGenerateGameResultWithRockAndPaperInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.PAPER);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.ROCK);
        assertThat(result.getResult(), is(GameResult.LOSE));
    }

    @Test
    public void testGenerateGameResultWithRockAndRockInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.ROCK);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.ROCK);
        assertThat(result.getResult(), is(GameResult.EQUAL));
    }

    @Test
    public void testGenerateGameResultWithRockAndScissorInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.SCISSORS);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.ROCK);
        assertThat(result.getResult(), is(GameResult.VICTORY));
    }

    @Test
    public void testGenerateGameResultWithPaperAndRockInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.ROCK);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.PAPER);
        assertThat(result.getResult(), is(GameResult.VICTORY));
    }

    @Test
    public void testGenerateGameResultWithPaperAndPaperInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.PAPER);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.PAPER);
        assertThat(result.getResult(), is(GameResult.EQUAL));
    }

    @Test
    public void testGenerateGameResultWithPaperAndScissorInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.SCISSORS);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.PAPER);
        assertThat(result.getResult(), is(GameResult.LOSE));
    }

    @Test
    public void testGenerateGameResultWithScissorAndRockInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.ROCK);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.SCISSORS);
        assertThat(result.getResult(), is(GameResult.LOSE));
    }

    @Test
    public void testGenerateGameResultWithScissorAndPaperInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.PAPER);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.SCISSORS);
        assertThat(result.getResult(), is(GameResult.VICTORY));
    }

    @Test
    public void testGenerateGameResultWithScissorAndScissorInPatternMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.PATTERN);
        when(mockedOpponentService.patternSymbol(anyInt())).thenReturn(GameSymbol.SCISSORS);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.SCISSORS);
        assertThat(result.getResult(), is(GameResult.EQUAL));
    }
    @Test
    public void testGenerateGameResultWithScissorAndScissorInAIMode() {
        ReflectionTestUtils.setField(classUnderTest, "gameMode", GameMode.AI);
        when(mockedOpponentService.aiSymbol(anyList(), anyMap())).thenReturn(GameSymbol.SCISSORS);
        GameResponse result = classUnderTest.generateGameResult(GameSymbol.SCISSORS);
        assertThat(result.getResult(), is(GameResult.EQUAL));
    }
}

