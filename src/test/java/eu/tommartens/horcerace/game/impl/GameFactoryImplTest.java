package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.deck.DeckFactory;
import eu.tommartens.horcerace.game.GameFactory;
import eu.tommartens.horcerace.lane.LaneFactory;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class GameFactoryImplTest {

    private GameFactory gameFactory;
    private DeckFactory deckFactory;
    private LaneFactory laneFactory;

    @Before
    public void setUp() throws Exception {
        deckFactory = mock(DeckFactory.class);
        laneFactory = mock(LaneFactory.class);
        gameFactory = new GameFactoryImpl(deckFactory, laneFactory);
    }

    @Test
    public void create() {
    }
}