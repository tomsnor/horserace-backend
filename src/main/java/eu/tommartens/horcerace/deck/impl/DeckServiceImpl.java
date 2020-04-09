package eu.tommartens.horcerace.deck.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckFactory;
import eu.tommartens.horcerace.deck.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeckServiceImpl implements DeckService {

    private DeckFactory deckFactory;

    @Autowired
    public DeckServiceImpl(DeckFactory deckFactory) {
        this.deckFactory = deckFactory;
    }

    @Override
    public Deck create() {
        return deckFactory.create();
    }

    @Override
    public Card drawCardAndAddToPile(final Deck deck) {
        final Card card = deck.getCards().remove(0);
        deck.getPile().add(card);
        return card;
    }

    @Override
    public Card removeCardFromDeck(final Deck deck, final Face face, final Suit suit) {
        final Card card = this.findCard(deck, face, suit);
        deck.getCards().remove(card);
        return card;
    }

    protected Card findCard(final Deck deck, final Face face, final Suit suit) {
        final Card cardToFind = new Card(face, suit);
        return deck.getCards().stream().filter(card -> card.equals(cardToFind)).findFirst().get();
    }
}
