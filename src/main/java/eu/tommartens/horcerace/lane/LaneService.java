package eu.tommartens.horcerace.lane;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;

public interface LaneService {

    Lane create(final Deck deck, final Face face, final Suit suit);

    Lane process(Lane lane, Card card);

    Lane setStatus(Lane lane, LaneStatus status);

}