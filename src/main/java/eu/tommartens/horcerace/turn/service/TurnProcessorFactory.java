package eu.tommartens.horcerace.turn.service;

import eu.tommartens.horcerace.card.data.Card;
import eu.tommartens.horcerace.game.data.Game;

public interface TurnProcessorFactory {

    TurnProcessor get(Game game, Card card);

}
