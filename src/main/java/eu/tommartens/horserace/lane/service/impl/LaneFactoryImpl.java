package eu.tommartens.horserace.lane.service.impl;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.card.data.Face;
import eu.tommartens.horserace.card.data.Suit;
import eu.tommartens.horserace.deck.data.Deck;
import eu.tommartens.horserace.deck.service.DeckService;
import eu.tommartens.horserace.lane.data.Lane;
import eu.tommartens.horserace.lane.service.LaneFactory;
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
