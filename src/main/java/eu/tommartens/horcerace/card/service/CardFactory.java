package eu.tommartens.horcerace.card.service;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.card.data.Face;
import eu.tommartens.horcerace.card.data.Suit;
import org.springframework.lang.NonNull;

public interface CardFactory {

    Card create(Face face, @NonNull Suit suit);

}
