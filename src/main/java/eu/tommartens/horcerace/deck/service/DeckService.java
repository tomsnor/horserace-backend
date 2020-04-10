package eu.tommartens.horcerace.deck.service;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.card.data.Face;
import eu.tommartens.horcerace.card.data.Suit;
import eu.tommartens.horcerace.deck.data.Deck;

public interface DeckService {

    Card drawCardAndAddToPile(Deck deck);

    Card removeCardFromDeck(final Deck deck, final Face face, final Suit suit);
}
