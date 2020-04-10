package eu.tommartens.horcerace.lane.service;

import eu.tommartens.horcerace.card.data.Face;
import eu.tommartens.horcerace.card.data.Suit;
import eu.tommartens.horcerace.deck.data.Deck;
import eu.tommartens.horcerace.lane.data.Lane;

public interface LaneFactory {

    Lane create(final Deck deck, final Face face, final Suit suit);

}
