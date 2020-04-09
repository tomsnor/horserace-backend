package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.game.GameFacade;
import eu.tommartens.horcerace.game.GameService;
import org.junit.Before;
import org.junit.Test;
import org.modelmapper.ModelMapper;

import static org.mockito.Mockito.mock;

public class GameFacadeImplTest {

    private GameFacade gameFacade;

    private GameService gameService;
    private ModelMapper modelMapper;

    @Before
    public void setUp() throws Exception {
        GameService gameService = mock(GameService.class);
        ModelMapper modelMapper = mock(ModelMapper.class);
        gameFacade = new GameFacadeImpl(gameService, modelMapper);
    }

    @Test
    public void create() {
    }

    @Test
    public void get() {
    }

    @Test
    public void iterate() {
    }
}