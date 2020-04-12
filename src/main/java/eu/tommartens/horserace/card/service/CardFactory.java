package eu.tommartens.horserace.card.service;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.card.data.Face;
import eu.tommartens.horserace.card.data.Suit;
import org.springframework.lang.NonNull;

public interface CardFactory {

    Card create(Face face, @NonNull Suit suit);

}
