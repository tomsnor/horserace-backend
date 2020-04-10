package eu.tommartens.horcerace.game.service.impl;

import eu.tommartens.horcerace.deck.data.Deck;
import eu.tommartens.horcerace.deck.service.DeckFactory;
import eu.tommartens.horcerace.game.data.Game;
import eu.tommartens.horcerace.game.data.GameStatus;
import eu.tommartens.horcerace.game.service.GameFactory;
import eu.tommartens.horcerace.lane.data.Lane;
import eu.tommartens.horcerace.lane.service.LaneFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

import static eu.tommartens.horcerace.card.data.Face.ACE;
import static eu.tommartens.horcerace.card.data.Suit.CLUBS;
import static eu.tommartens.horcerace.card.data.Suit.DIAMONDS;
import static eu.tommartens.horcerace.card.data.Suit.HEARTS;
import static eu.tommartens.horcerace.card.data.Suit.SPADES;

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
