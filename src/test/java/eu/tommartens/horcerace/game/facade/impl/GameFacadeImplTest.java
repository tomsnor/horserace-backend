package eu.tommartens.horcerace.game.facade.impl;

import eu.tommartens.horcerace.game.data.Game;
import eu.tommartens.horcerace.game.data.GameDTO;
import eu.tommartens.horcerace.game.facade.GameFacade;
import eu.tommartens.horcerace.game.service.GameService;
import eu.tommartens.horcerace.turn.service.AfterTurnProcessor;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameFacadeImplTest {

    private GameFacade gameFacade;

    private GameService gameService;
    private ModelMapper modelMapper;
    private AfterTurnProcessor afterTurnProcessor;

    @Before
    public void setUp() throws Exception {
        gameService = mock(GameService.class);
        modelMapper = mock(ModelMapper.class);
        afterTurnProcessor = mock(AfterTurnProcessor.class);
        gameFacade = new GameFacadeImpl(gameService, modelMapper);
        ((GameFacadeImpl) gameFacade).setAfterTurnProcessor(Collections.singletonList(afterTurnProcessor));
    }

    @Test
    public void create() {
        Game game = mock(Game.class);
        GameDTO expected = mock(GameDTO.class);
        when(gameService.create()).thenReturn(game);
        when(modelMapper.map(game, GameDTO.class)).thenReturn(expected);

        GameDTO actual = gameFacade.create();

        assertEquals(actual, expected);
    }

    @Test
    public void get() {
        Game game = mock(Game.class);
        GameDTO expected = mock(GameDTO.class);
        when(gameService.get("id")).thenReturn(game);
        when(modelMapper.map(game, GameDTO.class)).thenReturn(expected);

        GameDTO actual = gameFacade.get("id");

        assertEquals(actual, expected);
    }

    @Test
    public void doTurn() {
        Game game = mock(Game.class);
        GameDTO expected = mock(GameDTO.class);
        when(gameService.get("id")).thenReturn(game);
        when(gameService.doTurn(game)).thenReturn(game);
        when(modelMapper.map(game, GameDTO.class)).thenReturn(expected);

        GameDTO actual = gameFacade.doTurn("id");

        verify(afterTurnProcessor).process(game);
        assertEquals(actual, expected);
    }
}