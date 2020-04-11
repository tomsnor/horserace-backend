package eu.tommartens.horserace.card.service.impl;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.card.data.Face;
import eu.tommartens.horserace.card.data.Joker;
import eu.tommartens.horserace.card.data.Suit;
import eu.tommartens.horserace.card.service.CardFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardFactoryImplTest {

    private CardFactory cardFactory;

    @Before
    public void setUp() {
        cardFactory = new CardFactoryImpl();
    }

    @Test
    public void createJoker() {
        Card card = cardFactory.create(null, Suit.JOKER);

        assertTrue(card instanceof Joker);
        assertEquals(card.getSuit(), Suit.JOKER);
    }

    @Test
    public void createCard() {
        Card card = cardFactory.create(Face.ACE, Suit.SPADES);

        assertEquals(card.getSuit(), Suit.SPADES);
        assertEquals(card.getFace(), Face.ACE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createThrowsExceptionWhenSuitIsNull() {
        cardFactory.create(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createThrowsExceptionWhenFaceIsNullAndSuitIsNotJoker() {
        cardFactory.create(null, Suit.CLUBS);
    }
}