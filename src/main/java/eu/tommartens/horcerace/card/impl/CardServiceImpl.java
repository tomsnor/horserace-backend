package eu.tommartens.horcerace.card.impl;

import eu.tommartens.horcerace.card.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardServiceImpl(final CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card create(final Face face, final Suit suit) {
        final Card card = new Card(face, suit);
        return this.cardRepository.saveAndFlush(card);
    }
}
