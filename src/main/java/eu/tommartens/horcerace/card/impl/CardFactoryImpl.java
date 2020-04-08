package eu.tommartens.horcerace.card.impl;

import eu.tommartens.horcerace.card.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import static eu.tommartens.horcerace.card.Suit.JOKER;

@Service
public class CardFactoryImpl implements CardFactory {

    @Override
    public Card create(Face face, @NonNull Suit suit) {
        if (JOKER.equals(suit)) {
            return new Joker();
        }
        return new Card(face, suit);
    }
}
