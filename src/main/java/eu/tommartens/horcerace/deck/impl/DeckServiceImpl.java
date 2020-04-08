package eu.tommartens.horcerace.deck.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.CardFactory;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    private CardFactory cardFactory;

    @Autowired
    public DeckServiceImpl(CardFactory cardFactory) {
        this.cardFactory = cardFactory;
    }

    @Override
    public Deck create() {
        final Deck deck = new Deck();
        deck.setCards(createCards());
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
    }

    protected void addJokers(List<Card> cards) {
        for (int i = 0; i < 2; i++) {
            Card joker = cardFactory.create(null, Suit.JOKER);
            cards.add(joker);
        }
    }

    @Override
    public Card drawCard(final Deck deck) {
        final List<Card> cards = deck.getCards();
        final List<Card> pile = deck.getPile();
        if (cards.size() <= 0) {
            cards.addAll(pile);
            pile.clear();
            Collections.shuffle(cards);
        }
        final Card card = cards.remove(0);
        pile.add(card);
        return card;
    }

    @Override
    public Card remove(final Deck deck, final Face face, final Suit suit) {
        final Card card = this.findCard(deck, face, suit);
        deck.getCards().remove(card);
        return card;
    }

    protected Card findCard(final Deck deck, final Face face, final Suit suit) {
        final Card cardToFind = new Card(face, suit);
        return deck.getCards().stream().filter(card -> card.equals(cardToFind)).findFirst().get();
    }
}
