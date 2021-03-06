package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.deck.service.DeckService;
import eu.tommartens.horserace.turn.service.TurnProcessorFactory;
import eu.tommartens.horserace.turn.service.TurnProcessorService;
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