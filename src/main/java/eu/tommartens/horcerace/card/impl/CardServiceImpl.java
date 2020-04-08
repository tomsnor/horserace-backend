package eu.tommartens.horcerace.card.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.CardService;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    @Override
    public Card create(final Face face, final Suit suit) {
        return new Card(face, suit);
    }
}
