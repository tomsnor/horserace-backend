package eu.tommartens.horcerace.turn;

import eu.tommartens.horcerace.card.Card;
import eu.tommartens.horcerace.game.Game;

public interface TurnProcessor {

    void processTurn(Game game, Card card);

}
