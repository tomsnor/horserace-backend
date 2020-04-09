package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.turn.TurnPostProcessor;
import org.junit.Before;
import org.junit.Test;

public class CheckForFinishTurnPostProcessorImplTest {

    private TurnPostProcessor checkForFinishTurnPostProcessor;

    @Before
    public void setUp() throws Exception {
        checkForFinishTurnPostProcessor = new CheckForFinishTurnPostProcessorImpl();
    }

    @Test
    public void process() {
    }
}