package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.lane.data.Lane;
import eu.tommartens.horserace.turn.service.TurnProcessor;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class JokerTurnProcessorImplTest {

    private TurnProcessor jokerTurnProcessor;

    @Before
    public void setUp() {
        this.jokerTurnProcessor = new JokerTurnProcessorImpl();
    }

    @Test
    @Parameters({
            "5,7,3,2,5,2,3,7",
            "0,0,0,1,1,1,1,0",
            "1,2,3,4,4,2,3,1",
            "1,2,2,2,2,1,1,1",
            "0,0,0,0,0,0,0,0",
            "5,5,5,5,5,5,5,5"
    })
    public void processTurnWith4Lanes(final int p1, final int p2, final int p3, final int p4, final int e1, final int e2, final int e3, final int e4) {
        final Game game = new Game();
        final Lane lane1 = new Lane();
        lane1.setPosition(p1);

        final Lane lane2 = new Lane();
        lane2.setPosition(p2);

        final Lane lane3 = new Lane();
        lane3.setPosition(p3);

        final Lane lane4 = new Lane();
        lane4.setPosition(p4);

        game.setLanes(Arrays.asList(lane1, lane2, lane3, lane4));

        this.jokerTurnProcessor.processTurn(game, null);

        assertEquals(lane1.getPosition(), e1);
        assertEquals(lane2.getPosition(), e2);
        assertEquals(lane3.getPosition(), e3);
        assertEquals(lane4.getPosition(), e4);
    }

}