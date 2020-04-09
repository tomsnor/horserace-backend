package eu.tommartens.horcerace.deck.impl;

import eu.tommartens.horcerace.card.CardFactory;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckFactory;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class DeckFactoryImplTest {

    private DeckFactory deckFactory;
    private CardFactory cardFactory;

    @Before
    public void setUp() throws Exception {
        cardFactory = mock(CardFactory.class);
        deckFactory = new DeckFactoryImpl(cardFactory);
    }

    @Test
    public void create() {
        Deck deck = deckFactory.create();
    }
}