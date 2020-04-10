package eu.tommartens.horcerace.lane.service.impl;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.card.data.Face;
import eu.tommartens.horcerace.card.data.Suit;
import eu.tommartens.horcerace.deck.data.Deck;
import eu.tommartens.horcerace.deck.service.DeckService;
import eu.tommartens.horcerace.lane.data.Lane;
import eu.tommartens.horcerace.lane.service.LaneFactory;
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
