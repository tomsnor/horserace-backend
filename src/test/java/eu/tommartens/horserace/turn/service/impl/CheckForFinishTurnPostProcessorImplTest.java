package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.game.data.GameStatus;
import eu.tommartens.horserace.lane.data.Lane;
import eu.tommartens.horserace.lane.data.LaneStatus;
import eu.tommartens.horserace.turn.service.TurnPostProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckForFinishTurnPostProcessorImplTest {

    private TurnPostProcessor checkForFinishTurnPostProcessor;

    @Before
    public void setUp() {
        checkForFinishTurnPostProcessor = new CheckForFinishTurnPostProcessorImpl();
    }

    @Test
    public void processSetsFinishedWinnerAndLoserIfFinished() {
        Game game = new Game();
        game.setFinish(10);
        Lane winningLane = new Lane();
        winningLane.setPosition(10);
        Lane losingLane1 = new Lane();
        losingLane1.setPosition(5);
        Lane losingLane2 = new Lane();
        losingLane2.setPosition(5);
        game.setLanes(Arrays.asList(winningLane, losingLane1, losingLane2));

        checkForFinishTurnPostProcessor.process(game);

        assertEquals(game.getStatus(), GameStatus.FINISHED);
        assertEquals(winningLane.getStatus(), LaneStatus.WINNER);
        assertEquals(losingLane1.getStatus(), LaneStatus.LOSER);
        assertEquals(losingLane2.getStatus(), LaneStatus.LOSER);
    }

    @Test
    public void processDoesNotChangeStatusesWhenNoLaneIsFinished() {
        Game game = mock(Game.class);
        game.setFinish(10);
        Lane lane1 = mock(Lane.class);
        Lane lane2 = mock(Lane.class);
        Lane lane3 = mock(Lane.class);
        when(game.getFinish()).thenReturn(10);
        when(game.getLanes()).thenReturn(Arrays.asList(lane1, lane2, lane3));

        checkForFinishTurnPostProcessor.process(game);

        verify(game, never()).setStatus(any(GameStatus.class));
        verify(lane1, never()).setStatus(any(LaneStatus.class));
        verify(lane2, never()).setStatus(any(LaneStatus.class));
        verify(lane3, never()).setStatus(any(LaneStatus.class));
    }
}