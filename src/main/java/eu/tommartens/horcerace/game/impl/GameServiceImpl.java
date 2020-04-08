package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameService;
import eu.tommartens.horcerace.game.GameStatus;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.lane.LaneService;
import eu.tommartens.horcerace.lane.LaneStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static eu.tommartens.horcerace.HorseRaceConstants.GAMES_CACHE_NAME;
import static eu.tommartens.horcerace.card.Face.ACE;
import static eu.tommartens.horcerace.card.Suit.CLUBS;
import static eu.tommartens.horcerace.card.Suit.DIAMONDS;
import static eu.tommartens.horcerace.card.Suit.HEARTS;
import static eu.tommartens.horcerace.card.Suit.SPADES;

@Service
public class GameServiceImpl implements GameService {

    private final DeckService deckService;
    private final LaneService laneService;

    @Autowired
    public GameServiceImpl(DeckService deckService, LaneService laneService) {
        this.deckService = deckService;
        this.laneService = laneService;
    }

    @Override
    @CachePut(value = GAMES_CACHE_NAME, key = "#result.id")
    public Game create() {
        final Game game = new Game();
        // todo: generate random unique key
        game.setId(Long.toString(System.currentTimeMillis()));
        game.setStatus(GameStatus.RUNNING);
        game.setFinish(10);
        final Deck deck = this.deckService.create();
        game.setDeck(deck);
        final Lane lane1 = this.laneService.create(deck, ACE, SPADES);
        final Lane lane2 = this.laneService.create(deck, ACE, HEARTS);
        final Lane lane3 = this.laneService.create(deck, ACE, CLUBS);
        final Lane lane4 = this.laneService.create(deck, ACE, DIAMONDS);
        game.setLanes(Arrays.asList(lane1, lane2, lane3, lane4));
        return game;
    }

    @Override
    @Cacheable(value = GAMES_CACHE_NAME)
    public Game get(final String id) {
        throw new RuntimeException();
    }

    @Override
    @CachePut(value = GAMES_CACHE_NAME, key = "#result.id")
    public Game iterate(final Game game) {
        final Card card = this.deckService.burn(game.getDeck());
        for (final Lane lane : game.getLanes()) {
            this.laneService.process(lane, card);
            if (lane.getPosition() >= game.getFinish()) {
                this.laneService.setStatus(lane, LaneStatus.WINNER);
                this.finish(game);
            }
        }
        return game;
    }

    protected void finish(final Game game) {
        game.setStatus(GameStatus.FINISHED);
        for (final Lane lane : game.getLanes()) {
            if (!lane.getLaneStatus().equals(LaneStatus.WINNER))
                this.laneService.setStatus(lane, LaneStatus.LOSER);
        }
    }
}
