package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameRepository;
import eu.tommartens.horcerace.game.GameService;
import eu.tommartens.horcerace.game.GameStatus;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.lane.LaneService;
import eu.tommartens.horcerace.lane.LaneStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static eu.tommartens.horcerace.card.Face.ACE;
import static eu.tommartens.horcerace.card.Suit.CLUBS;
import static eu.tommartens.horcerace.card.Suit.DIAMONDS;
import static eu.tommartens.horcerace.card.Suit.HEARTS;
import static eu.tommartens.horcerace.card.Suit.SPADES;

@Service
public class GameServiceImpl implements GameService {

    private final DeckService deckService;
    private final GameRepository gameRepository;
    private final LaneService laneService;

    @Autowired
    public GameServiceImpl(final DeckService deckService, final GameRepository gameRepository, final LaneService laneService) {
        this.deckService = deckService;
        this.gameRepository = gameRepository;
        this.laneService = laneService;
    }

    @Override
    public Game create() {
        final Game game = new Game();
        game.setStatus(GameStatus.RUNNING);
        game.setFinish(10);
        final Deck deck = this.deckService.create();
        game.setDeck(deck);
        final Lane lane1 = this.laneService.create(deck, ACE, SPADES);
        final Lane lane2 = this.laneService.create(deck, ACE, HEARTS);
        final Lane lane3 = this.laneService.create(deck, ACE, CLUBS);
        final Lane lane4 = this.laneService.create(deck, ACE, DIAMONDS);
        game.setLanes(Arrays.asList(lane1, lane2, lane3, lane4));
        return this.gameRepository.saveAndFlush(game);
    }

    @Override
    public Game get(final long id) {
        return this.gameRepository.getOne(id);
    }

    @Override
    public Game iterate(final long id) {
        final Game game = this.gameRepository.getOne(id);
        if (game.getStatus().equals(GameStatus.RUNNING)) {
            final Card card = this.deckService.burn(game.getDeck());
            for (final Lane lane : game.getLanes()) {
                this.laneService.process(lane, card);
                if (lane.getPosition() >= game.getFinish()) {
                    this.laneService.setStatus(lane, LaneStatus.WINNER);
                    this.finish(game);
                }
            }
        }
        return this.gameRepository.saveAndFlush(game);
    }

    protected void finish(final Game game) {
        game.setStatus(GameStatus.FINISHED);
        for (final Lane lane : game.getLanes()) {
            if (!lane.getLaneStatus().equals(LaneStatus.WINNER))
                this.laneService.setStatus(lane, LaneStatus.LOSER);
        }
    }
}
