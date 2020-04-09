package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.turn.TurnProcessorFactory;
import eu.tommartens.horcerace.turn.TurnProcessorService;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class TurnProcessorFacadeImplTest {

    private TurnProcessorService turnProcessorFacade;

    private TurnProcessorFactory turnProcessorFactory;
    private DeckService deckService;

    @Before
    public void setUp() throws Exception {
        turnProcessorFactory = mock(TurnProcessorFactory.class);
        deckService = mock(DeckService.class);
        turnProcessorFacade = new TurnProcessorServiceImpl(turnProcessorFactory, deckService);
    }

    @Test
    public void processPreTurn() {
    }

    @Test
    public void processTurn() {
    }

    @Test
    public void processPostTurn() {
    }
}