package eu.tommartens.horserace.game.service.impl;

import eu.tommartens.horserace.game.service.GameFactory;
import eu.tommartens.horserace.game.service.GameService;
import eu.tommartens.horserace.turn.service.TurnProcessorService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class GameServiceImplTest {

    private GameService gameService;

    private TurnProcessorService turnProcessorService;
    private GameFactory gameFactory;

    @Before
    public void setUp() throws Exception {
        turnProcessorService = mock(TurnProcessorService.class);
        gameFactory = mock(GameFactory.class);
        gameService = new GameServiceImpl(turnProcessorService, gameFactory);
    }

    @Test
    public void create() {
    }

    @Test
    public void get() {
    }

    @Test
    public void doTurn() {
    }
}