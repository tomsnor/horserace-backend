package eu.tommartens.horcerace.deck;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;

public interface DeckService {

    Deck create();

    Card drawCard(Deck deck);

    Card remove(final Deck deck, final Face face, final Suit suit);
}
