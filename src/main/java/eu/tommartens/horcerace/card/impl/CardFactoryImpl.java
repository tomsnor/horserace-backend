package eu.tommartens.horcerace.card.impl;

import eu.tommartens.horcerace.card.*;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import static eu.tommartens.horcerace.card.Suit.JOKER;

@Service
public class CardFactoryImpl implements CardFactory {

    @Override
    public Card create(Face face, @NonNull Suit suit) {
        Assert.notNull(suit, "suit can not be null");
        if (JOKER.equals(suit)) {
            return new Joker();
        }
        Assert.notNull(face, "Face can only be null for Joker");
        return new Card(face, suit);
    }
}
