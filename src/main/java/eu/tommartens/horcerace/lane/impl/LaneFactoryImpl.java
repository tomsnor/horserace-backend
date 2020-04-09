package eu.tommartens.horcerace.lane.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.lane.LaneFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaneFactoryImpl implements LaneFactory {

    private final DeckService deckService;

    @Autowired
    public LaneFactoryImpl(final DeckService deckService) {
        this.deckService = deckService;
    }

    @Override
    public Lane create(final Deck deck, final Face face, final Suit suit) {
        final Card aceOfSpades = this.deckService.removeCardFromDeck(deck, face, suit);
        return new Lane(aceOfSpades);
    }

}