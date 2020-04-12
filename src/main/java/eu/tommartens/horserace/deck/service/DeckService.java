package eu.tommartens.horserace.deck.service;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.card.data.Face;
import eu.tommartens.horserace.card.data.Suit;
import eu.tommartens.horserace.deck.data.Deck;

public interface DeckService {

    Card drawCardAndAddToPile(Deck deck);

    Card removeCardFromDeck(final Deck deck, final Face face, final Suit suit);
}
