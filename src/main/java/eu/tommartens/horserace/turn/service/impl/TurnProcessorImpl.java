package eu.tommartens.horserace.turn.service.impl;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.game.data.Game;
import eu.tommartens.horserace.lane.data.Lane;
import eu.tommartens.horserace.turn.service.TurnProcessor;
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
