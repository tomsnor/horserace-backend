package eu.tommartens.horcerace.deck.service.impl;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.card.data.Face;
import eu.tommartens.horcerace.card.data.Suit;
import eu.tommartens.horcerace.card.service.CardFactory;
import eu.tommartens.horcerace.deck.data.Deck;
import eu.tommartens.horcerace.deck.service.DeckFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeckFactoryImpl implements DeckFactory {

    private CardFactory cardFactory;

    @Autowired
    public DeckFactoryImpl(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    @Override
    public Deck create() {
        Deck deck = new Deck();
        deck.setStack(createCards());
        return deck;
    }

    protected List<Card> createCards() {
        final List<Card> cards = new ArrayList<>(54);
        addRegularCards(cards);
        addJokers(cards);
        Collections.shuffle(cards);
        return cards;
    }

    protected void addRegularCards(List<Card> cards) {
        for (final Suit suit : Suit.values()) {
            for (final Face face : Face.values()) {
                if (suit != Suit.JOKER) {
                    final Card card = this.cardFactory.create(face, suit);
                    cards.add(card);
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            Card ace = cardFactory.create(Face.KING, Suit.SPADES);
            cards.add(ace);
        }
    }

    protected void addJokers(List<Card> cards) {
        for (int i = 0; i < 2; i++) {
            Card joker = cardFactory.create(null, Suit.JOKER);
            cards.add(joker);
        }
    }
}
