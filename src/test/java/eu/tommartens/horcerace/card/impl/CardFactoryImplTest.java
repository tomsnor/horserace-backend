package eu.tommartens.horcerace.card.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.CardFactory;
import eu.tommartens.horcerace.card.Joker;
import eu.tommartens.horcerace.card.Suit;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardFactoryImplTest {

    private CardFactory cardFactory;

    @Before
    public void setUp() throws Exception {
        cardFactory = new CardFactoryImpl();
    }

    @Test
    public void createJoker() {
        Card card = cardFactory.create(null, Suit.JOKER);

        assertTrue(card instanceof Joker);
        assertEquals(card.getSuit(), Suit.JOKER);
    }
}