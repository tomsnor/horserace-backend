package eu.tommartens.horcerace.turn;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;

public interface TurnProcessorFactory {

    TurnProcessor get(Game game, Card card);

}
