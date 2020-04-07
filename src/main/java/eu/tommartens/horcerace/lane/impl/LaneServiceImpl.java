package eu.tommartens.horcerace.lane.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.card.Face;
import eu.tommartens.horcerace.card.Suit;
import eu.tommartens.horcerace.deck.Deck;
import eu.tommartens.horcerace.deck.DeckService;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.lane.LaneRepository;
import eu.tommartens.horcerace.lane.LaneService;
import eu.tommartens.horcerace.lane.LaneStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LaneServiceImpl implements LaneService {

    private final DeckService deckService;
    private final LaneRepository laneRepository;

    @Autowired
    public LaneServiceImpl(final DeckService deckService, final LaneRepository laneRepository) {
        this.deckService = deckService;
        this.laneRepository = laneRepository;
    }

    @Override
    public Lane create(final Deck deck, final Face face, final Suit suit) {
        final Card aceOfSpades = this.deckService.remove(deck, face, suit);
        final Lane lane = new Lane(aceOfSpades);
        return this.laneRepository.saveAndFlush(lane);
    }

    @Override
    public Lane process(final Lane lane, final Card card) {
        if (lane.getCard().getSuit().equals(card.getSuit())) {
            lane.setPosition(lane.getPosition() + 1);
        }
        return this.laneRepository.saveAndFlush(lane);
    }

    @Override
    public Lane setStatus(final Lane lane, final LaneStatus status) {
        lane.setLaneStatus(status);
        return this.laneRepository.saveAndFlush(lane);
    }
}
