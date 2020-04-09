package eu.tommartens.horcerace.turn.impl;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;
import eu.tommartens.horcerace.lane.Lane;
import eu.tommartens.horcerace.turn.TurnProcessor;
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
