package eu.tommartens.horcerace.deck.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    @Override
    public Card drawCardAndAddToPile(final Deck deck) {
        List<Card> cardList = new ArrayList<>(deck.getCards());
        final Card card = cardList.remove(0);
        deck.getPile().add(card);
        deck.setCards(cardList);
        return card;
    }

    @Override
    public Card removeCardFromDeck(final Deck deck, final Face face, final Suit suit) {
        final Card card = this.findCard(deck, face, suit);
        List<Card> cardList = new ArrayList<>(deck.getCards());
        cardList.remove(card);
        deck.setCards(cardList);
        return card;
    }

    protected Card findCard(final Deck deck, final Face face, final Suit suit) {
        final Card cardToFind = new Card(face, suit);
        return deck.getCards().stream().filter(card -> card.equals(cardToFind)).findFirst().get();
    }
}
