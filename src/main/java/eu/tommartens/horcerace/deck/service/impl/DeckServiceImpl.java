package eu.tommartens.horcerace.deck.service.impl;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.card.data.Face;
import eu.tommartens.horcerace.card.data.Suit;
import eu.tommartens.horcerace.deck.data.Deck;
import eu.tommartens.horcerace.deck.service.DeckService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    @Override
    public Card drawCardAndAddToPile(final Deck deck) {
        List<Card> cardList = new ArrayList<>(deck.getStack());
        final Card card = cardList.remove(0);
        deck.getPile().add(card);
        deck.setStack(cardList);
        return card;
    }

    @Override
    public Card removeCardFromDeck(final Deck deck, final Face face, final Suit suit) {
        final Card card = this.findCard(deck, face, suit);
        List<Card> cardList = new ArrayList<>(deck.getStack());
        cardList.remove(card);
        deck.setStack(cardList);
        return card;
    }

    protected Card findCard(final Deck deck, final Face face, final Suit suit) {
        final Card cardToFind = new Card(face, suit);
        return deck.getStack().stream().filter(card -> card.equals(cardToFind)).findFirst().get();
    }
}
