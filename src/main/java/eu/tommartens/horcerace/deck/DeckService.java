package eu.tommartens.horcerace.deck;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;

public interface DeckService {

    Card drawCardAndAddToPile(Deck deck);

    Card removeCardFromDeck(final Deck deck, final Face face, final Suit suit);
}
