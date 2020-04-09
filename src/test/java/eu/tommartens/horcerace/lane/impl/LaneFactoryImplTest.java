package eu.tommartens.horcerace.lane.impl;

import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.lane.LaneFactory;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class LaneFactoryImplTest {

    private LaneFactory laneFactory;
    private DeckService deckService;

    @Before
    public void setUp() throws Exception {
        deckService = mock(DeckService.class);
        laneFactory = new LaneFactoryImpl(deckService);
    }

    @Test
    public void create() {
    }
}