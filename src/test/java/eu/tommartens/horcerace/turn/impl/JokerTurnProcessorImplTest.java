package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.turn.TurnProcessor;
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
        jokerTurnProcessor = new JokerTurnProcessorImpl();
    }

    @Test
    @Parameters({
            "5,7,3,2,3,2,5,7",
            "0,0,0,1,1,1,1,0",
            "1,2,3,4,4,3,2,1",
            "1,2,2,2,2,1,1,1"
    })
    public void processTurnWith4Lanes(int p1, int p2, int p3, int p4, int e1, int e2, int e3, int e4) {
        Game game = new Game();
        Lane lane1 = new Lane();
        lane1.setPosition(p1);

        Lane lane2 = new Lane();
        lane2.setPosition(p2);

        Lane lane3 = new Lane();
        lane3.setPosition(p3);

        Lane lane4 = new Lane();
        lane4.setPosition(p4);

        game.setLanes(Arrays.asList(lane1, lane2, lane3, lane4));

        jokerTurnProcessor.processTurn(game, null);

        assertEquals(lane1.getPosition(), e1);
        assertEquals(lane2.getPosition(), e2);
        assertEquals(lane3.getPosition(), e3);
        assertEquals(lane4.getPosition(), e4);
    }

}