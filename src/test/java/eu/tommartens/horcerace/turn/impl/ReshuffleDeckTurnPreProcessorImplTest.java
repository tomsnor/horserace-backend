package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.turn.TurnPreProcessor;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class ReshuffleDeckTurnPreProcessorImplTest {

    private TurnPreProcessor reshuffleDeckTurnPreProcessor;

    @Before
    public void setUp() {
        reshuffleDeckTurnPreProcessor = new ReshuffleDeckTurnPreProcessorImpl();
    }

    @Test
    public void processPutsCardsFromPileBackIntoTheStack() {
        Game game = new Game();
        Deck deck = new Deck();
        Card expected = mock(Card.class);
        deck.setStack(new ArrayList<>());
        deck.setPile(Collections.singletonList(expected));
        game.setDeck(deck);

        reshuffleDeckTurnPreProcessor.process(game);

        assertTrue(game.getDeck().getStack().contains(expected));
        assertTrue(game.getDeck().getPile().isEmpty());
    }

    @Test
    public void processDoesntResetStackIfThereAreCardsLeft() {
        Game game = new Game();
        Deck deck = new Deck();
        Card cardInStack = mock(Card.class);
        Card cardInPile = mock(Card.class);
        deck.setStack(Collections.singletonList(cardInStack));
        deck.setPile(Collections.singletonList(cardInPile));
        game.setDeck(deck);

        reshuffleDeckTurnPreProcessor.process(game);

        assertFalse(game.getDeck().getStack().contains(cardInPile));
        assertFalse(game.getDeck().getPile().isEmpty());
        assertTrue(game.getDeck().getStack().contains(cardInStack));
        assertTrue(game.getDeck().getPile().contains(cardInPile));
    }
}