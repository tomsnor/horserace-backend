package eu.tommartens.horserace.lane.service;

import eu.tommartens.horserace.card.data.Face;
import eu.tommartens.horserace.card.data.Suit;
import eu.tommartens.horserace.deck.data.Deck;
import eu.tommartens.horserace.lane.data.Lane;

public interface LaneFactory {

    Lane create(final Deck deck, final Face face, final Suit suit);

}
