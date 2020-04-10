package eu.tommartens.horcerace.deck.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckService;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class DeckServiceImplTest {

    private DeckService deckService;

    @Before
    public void setUp() {
        deckService = new DeckServiceImpl();
    }

    @Test
    public void drawCardAndAddToPile() {
        Card expected = mock(Card.class);
        Deck deck = new Deck();
        deck.setStack(Collections.singletonList(expected));

        Card actual = deckService.drawCardAndAddToPile(deck);

        assertEquals(expected, actual);
        assertTrue(deck.getPile().contains(expected));
    }

    @Test
    public void removeCardFromDeck() {
        Card expected = new Card(Face.ACE, Suit.SPADES);
        Deck deck = new Deck();
        deck.setStack(Collections.singletonList(expected));

        Card actual = deckService.removeCardFromDeck(deck, Face.ACE, Suit.SPADES);

        assertEquals(expected, actual);
        assertTrue(deck.getStack().isEmpty());
    }
}