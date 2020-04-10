package eu.tommartens.horcerace.turn.service.impl;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.game.data.Game;
import eu.tommartens.horcerace.lane.data.Lane;
import eu.tommartens.horcerace.turn.service.TurnProcessor;
import org.springframework.stereotype.Service;

@Service("defaultTurnProcessor")
public class TurnProcessorImpl implements TurnProcessor {

    @Override
    public void processTurn(Game game, Card card) {
        for (final Lane lane : game.getLanes()) {
            if (lane.getCard().getSuit().equals(card.getSuit())) {
                lane.setPosition(lane.getPosition() + 1);
            }
        }
    }
}
