package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.turn.TurnProcessor;
import eu.tommartens.horcerace.turn.TurnProcessorFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.mockito.Mockito.mock;

public class TurnProcessorFactoryImplTest {

    private TurnProcessorFactory turnProcessorFactory;

    private Map<Suit, TurnProcessor> turnProcessorMap;
    private TurnProcessor defaultTurnProcessor;

    @Before
    public void setUp() throws Exception {
        turnProcessorMap = mock(Map.class);
        defaultTurnProcessor = mock(TurnProcessor.class);
        turnProcessorFactory = new TurnProcessorFactoryImpl(turnProcessorMap, defaultTurnProcessor);
    }

    @Test
    public void get() {
    }
}