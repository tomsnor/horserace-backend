package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.card.data.Suit;
import eu.tommartens.horserace.turn.service.TurnProcessor;
import eu.tommartens.horserace.turn.service.TurnProcessorFactory;
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