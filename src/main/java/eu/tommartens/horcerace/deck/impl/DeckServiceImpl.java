package eu.tommartens.horcerace.deck.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.CardService;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckRepository;
import eu.tommartens.horcerace.deck.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DeckServiceImpl implements DeckService {

    private final CardService cardService;
    private final DeckRepository deckRepository;

    @Autowired
    public DeckServiceImpl(final CardService cardService, final DeckRepository deckRepository) {
        this.cardService = cardService;
        this.deckRepository = deckRepository;
    }

    @Override
    public Deck create() {
        final Deck deck = new Deck();
        deck.setPile(new ArrayList<>());
        final List<Card> cards = new ArrayList<>(52);

        for (final Suit suit : Suit.values()) {
            for (final Face face : Face.values()) {
                final Card card = this.cardService.create(face, suit);
                cards.add(card);
            }
        }
        deck.setCards(cards);
        Collections.shuffle(cards);
        return this.deckRepository.saveAndFlush(deck);
    }

    @Override
    public Card burn(final Deck deck) {
        final List<Card> cards = deck.getCards();
        final List<Card> pile = deck.getPile();
        if (cards.size() <= 0) {
            cards.addAll(pile);
            pile.clear();
            Collections.shuffle(cards);
        }
        final Card card = cards.remove(0);
        pile.add(card);
        this.deckRepository.saveAndFlush(deck);
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
