package eu.tommartens.horserace.turn.service;

import eu.tommartens.horserace.card.data.Card;
import eu.tommartens.horserace.game.data.Game;

public interface TurnProcessorFactory {

    TurnProcessor get(Game game, Card card);

}
