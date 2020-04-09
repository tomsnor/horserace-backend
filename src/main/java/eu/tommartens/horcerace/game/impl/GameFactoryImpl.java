package eu.tommartens.horcerace.game.impl;

import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckFactory;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.game.GameFactory;
import eu.tommartens.horcerace.game.GameStatus;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.lane.LaneFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static eu.tommartens.horcerace.card.Face.ACE;
import static eu.tommartens.horcerace.card.Suit.CLUBS;
import static eu.tommartens.horcerace.card.Suit.DIAMONDS;
import static eu.tommartens.horcerace.card.Suit.HEARTS;
import static eu.tommartens.horcerace.card.Suit.SPADES;

@Service
public class GameFactoryImpl implements GameFactory {

    private final DeckFactory deckFactory;
    private final LaneFactory laneFactory;

    @Autowired
    public GameFactoryImpl(DeckFactory deckFactory, LaneFactory laneFactory) {
        this.deckFactory = deckFactory;
        this.laneFactory = laneFactory;
    }

    @Override
    public Game create() {
        final Game game = new Game();
        game.setId(Long.toString(System.currentTimeMillis()));
        game.setStatus(GameStatus.RUNNING);
        game.setFinish(10);
        final Deck deck = this.deckFactory.create();
        game.setDeck(deck);
        final Lane lane1 = this.laneFactory.create(deck, ACE, SPADES);
        final Lane lane2 = this.laneFactory.create(deck, ACE, HEARTS);
        final Lane lane3 = this.laneFactory.create(deck, ACE, CLUBS);
        final Lane lane4 = this.laneFactory.create(deck, ACE, DIAMONDS);
        game.setLanes(Arrays.asList(lane1, lane2, lane3, lane4));
        return game;
    }
}
