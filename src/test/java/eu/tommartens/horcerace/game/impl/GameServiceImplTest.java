package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameService;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.lane.LaneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class GameServiceImplTest {

    private GameService gameService;

    private DeckService deckService;
    private LaneService laneService;

    @BeforeEach
    void setUp() {
        deckService = mock(DeckService.class);
        laneService = mock(LaneService.class);
//        gameService = new GameServiceImpl(deckService, laneService);
    }

    @Test
    void shuffleLanes() {
        Game game = new Game();
        Lane lane1 = new Lane();
        lane1.setPosition(5);
        Lane lane2 = new Lane();
        lane2.setPosition(7);

        Lane lane3 = new Lane();
        lane3.setPosition(3);

        Lane lane4 = new Lane();
        lane4.setPosition(2);
        game.setLanes(Arrays.asList(lane1, lane2, lane3, lane4));

//        gameService.shuffleLanes(game);

        assertEquals(lane1.getPosition(), 3);
        assertEquals(lane2.getPosition(), 2);
        assertEquals(lane3.getPosition(), 5);
        assertEquals(lane4.getPosition(), 7);
    }

    @Test
    void shuffleLanes2() {
        Game game = new Game();
        Lane lane1 = new Lane();
        lane1.setPosition(1);
        Lane lane2 = new Lane();
        lane2.setPosition(0);

        Lane lane3 = new Lane();
        lane3.setPosition(0);

        Lane lane4 = new Lane();
        lane4.setPosition(0);
        game.setLanes(Arrays.asList(lane1, lane2, lane3, lane4));

//        gameService.shuffleLanes(game);

        assertEquals(lane1.getPosition(), 0);
        assertEquals(lane2.getPosition(), 1);
        assertEquals(lane3.getPosition(), 1);
        assertEquals(lane4.getPosition(), 1);
    }
}